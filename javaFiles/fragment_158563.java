final String schemaLocation = "/home/javier/FlinkProjects/kafka-flink/src/main/java/com/grallandco/demos/avro.json";
final Schema avroSchema = new Schema.Parser().parse(new File(schemaLocation));
final MessageType parquetSchema = new AvroSchemaConverter().convert(avroSchema);
final WriteSupport writeSupport = new AvroWriteSupport(parquetSchema,  avroSchema);
final Path path = new Path("/user/hduser/parquet-files/data" + 
       postfijoFilename + ".parquet");
Configuration configuration = new Configuration();
String hdfsUrl = "hdfs://hadoopnamenode:9000/";
String username = "hduser";
FileSystem fs= FileSystem.get(new URI(hdfsUrl), configuration);
UserGroupInformation ugi = 
UserGroupInformation.createRemoteUser(username);
ugi.doAs(new PrivilegedExceptionAction<Void>() {
            public Void run() throws Exception { 
                AvroParquetWriter parquetWriter = new 
                    AvroParquetWriter(path,
                    avroSchema, 
                    CompressionCodecName.SNAPPY,                
                    ParquetWriter.DEFAULT_BLOCK_SIZE, 
                    ParquetWriter.DEFAULT_PAGE_SIZE);
                final GenericRecord record = new 
                    GenericData.Record(avroSchema);
                record.put(Constantes.CAMPO_ID, datos[0]);
                record.put("movie", datos[1]);
                record.put("date", datos[2]);
                record.put("imdb", datos[3]);
                parquetWriter.write(record);
                return null;
                }
    });