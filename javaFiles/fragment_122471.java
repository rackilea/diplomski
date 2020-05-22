Session ses = ...
final InputStream finalCompiledReportStream = compiledReportStream;
final OutputStream finalByteArrayOutputStream = byteArrayOutputStream;
ses.doWork(new Work() {
    public void execute(Connection connection) throws SQLException {
       try {
           JasperFillManager.fillReportToStream(finalCompiledReportStream, finalByteArrayOutputStream, parameters, connection);
       } catch (JRException e) {
           ReportAction.this.logger.error(e);
       }
    }
});