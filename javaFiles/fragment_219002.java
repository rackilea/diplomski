DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

Executor executor = new DefaultExecutor();
executor.execute(cmdLine, resultHandler);

int exitValue = resultHandler.waitFor();

return exitValue;