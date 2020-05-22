try {
      f = new BufferedInputStream(new FileInputStream(source));
      f.read(buffer);
  } finally {
      IOUtils.closeQuietly(f);
  }