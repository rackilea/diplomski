File[] allCsvFiles = directory.listFiles( new FilenameFilter() {
  public boolean accept(File dir, String name) {
    if ( name.toUpperCase().endsWith(".CSV") ) {
      return new File(dir,name).isFile(); // Make sure we don't accept sub-directories ending in .csv
    }
  }
});