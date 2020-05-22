try {
      f = fileSystem.open(source);
      f.read(buffer);
  } finally {
      IOUtils.closeQuietly(f);
  }