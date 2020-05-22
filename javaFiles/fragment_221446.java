File folder = new File(dbBackupLocation + "/" + dbHost);
File[] listOfFiles = folder.listFiles();
if (listOfFiles != null && listOfFiles.length > 0) {
  // The array isn't empty.
  Arrays.sort(listOfFiles, new Comparator<File>() {
    @Override
    public int compare(File f1, File f2) {
      return Long.valueOf(f1.lastModified())
          .compareTo(f2.lastModified());
    }
  });
}