printError(Throwable t) {
      if(System.getProperties("detailedDebugMode") != null && "true".equalsIgnoreCase(System.getProperties("detailedDebugMode"))) {
          LOG.error("Here is the message", e);
      } else {
          LOG.error("Here is the message only");
      }
  }