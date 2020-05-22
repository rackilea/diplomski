@Override
public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
  return (ex, method, params) -> {
    service.call();
    logger.fatal(ex);
  };
}