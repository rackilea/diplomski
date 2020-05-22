public static void closeStream(Closeable closeable) {
    if(null != closeable) {
      try {
        closeable.close();
      } catch(IOException ex) {
        LOG.warning("Failed to properly close closeable.", ex);
      }
    }
  }