private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(FileAppender.class);
private static LoggerFacade loggerFacade = new Log4jLogger(logger);

private static String tempDir = (String) System.getProperties().get("java.io.tmpdir");

private FileResourceManager frm = new FileResourceManager(tempDir, tempDir, false, loggerFacade);
private static OutputStream outputStream;

public void writeOut(E event) throws IOException {
    Object txId = null;
    try {
        frm.start();
        txId = frm.generatedUniqueTxId();
        frm.startTransaction(txId);
        outputStream = frm.writeResource(txId, fileName, true);
        frm.commitTransaction(txId);

    }

    catch (Exception e) {
        throw new IOException("DB rollback");
    }
}