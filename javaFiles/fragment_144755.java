File file = new File("/pathToVersionFolders");
File[] files = file.listFiles(new FilenameFilter() {
  @Override
  public boolean accept(File dir, String name) {
      return new File(dir, name).isDirectory();
  }
});