public class SimpleS3ParquetUtilities implements S3Utilities {

    final Logger logger;
    String PATH_SCHEMA = "s3a";
    CompressionCodecName compressionCodecName;

    public SimpleS3ParquetUtilities(Logger logger) {
        this.logger = logger;
        this.compressionCodecName = CompressionCodecName.UNCOMPRESSED;
    }

    public SimpleS3ParquetUtilities(Logger logger, CompressionCodecName compressionCodecName) {
        this.logger = logger;
        this.compressionCodecName = compressionCodecName;
    }

    @Override
    public String writeTransactions(String bucket, String objectKey, List<Transaction> transactions)
            throws Exception {
        if (objectKey.charAt(0) != '/')
            objectKey = "/" + objectKey;
        Path file = new Path(PATH_SCHEMA, bucket, objectKey);
        Stopwatch sw = Stopwatch.createStarted();
        // convert the list into protobuf 
        List<TransactionProtos.Transaction> protoTransactions = Convertor.toProtoBuf(transactions);
        try (ProtoParquetWriter<TransactionProtos.Transaction> writer = new ProtoParquetWriter<TransactionProtos.Transaction>(
                file, TransactionProtos.Transaction.class, this.compressionCodecName,
                ProtoParquetWriter.DEFAULT_BLOCK_SIZE, ProtoParquetWriter.DEFAULT_PAGE_SIZE)) {

            for (TransactionProtos.Transaction transaction : protoTransactions) {
                writer.write(transaction);
            }
        }
        logger.info("Parquet write elapse:[{}{}] Time:{}ms items:{}", bucket, objectKey,
                sw.elapsed(TimeUnit.MILLISECONDS), transactions.size());
        return "";
    }

    @Override
    public List<Transaction> readTransactions(String bucket, String pathWithFileName)
            throws Exception {
        if (pathWithFileName.charAt(0) != '/')
            pathWithFileName = "/" + pathWithFileName;
        Path file = new Path(PATH_SCHEMA, bucket, pathWithFileName);
        Stopwatch sw = Stopwatch.createStarted();
        try (ParquetReader<TransactionProtos.Transaction.Builder> reader = ProtoParquetReader.<TransactionProtos.Transaction.Builder>builder(
                file).build()) {
            List<TransactionProtos.Transaction> transactions = new ArrayList<TransactionProtos.Transaction>();
            TransactionProtos.Transaction.Builder builder = reader.read();
            while (builder != null) {
                TransactionProtos.Transaction transaction = builder.build();
                transactions.add(transaction);
                builder = reader.read();
            }
            logger.info("Parquet read elapsed:[{}{}] Time:{}ms items:{}", bucket, pathWithFileName,
                    sw.elapsed(TimeUnit.MILLISECONDS), transactions.size());
            return Convertor.fromProtoBuf(transactions);
        }
    }
}