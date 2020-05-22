InputStreamReaderRunnable errorStreamReaderRunnable = new InputStreamReaderRunnable(spark.getErrorStream(), "error");
    Thread errorThread = new Thread(errorStreamReaderRunnable, "LogStreamReader error");
    errorThread.start();

   int result= spark.waitFor();
   if(result!=0) {
            String errorMessage = extractExceptionMessage(errorStreamReaderRunnable.getMessage());
            LOGGER.error(errorMessage);
        }