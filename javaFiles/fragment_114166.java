public static void showFileSizes(File dir) {
  File[] files = dir.listFiles(); // (1)
  long[] fileSizes = new long[files.length];
  for(int i = 0; i < files.length; i++) {
    fileSizes[i] = calculateFileSize(file[i]);//invoke the method corresponding to (2).
    boolean isDirectory = files[i].isDirectory();
    System.out.println(((isDirectory)?"DIR":"FILE") + " - " + files[i].getAbsolutePath() + friendlyFileSize(fileSizes[i]));// as (3)
  }
}