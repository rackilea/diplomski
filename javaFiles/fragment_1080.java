public class MyTraceInterceptor extends CustomizableTraceInterceptor {

  protected void writeToLog(Log logger, String message, Throwable ex) {
    if (ex != null) {
        logger.info(message, ex);
    } else {
        logger.info(message);
    }
  }


  protected boolean isInterceptorEnabled(MethodInvocation invocation, Log logger) {
    return true;
  }
}