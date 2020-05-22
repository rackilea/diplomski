public static long calculateFileSize(File file) {
  long fileSize = 0L;
  if(file.isDirectory()) {
     File[] children = file.listFiles();
     for(File child : children) {
       fileSize += calculateFileSize(child);
     }
  }
  else {
    fileSize = file.length();
  }
  return fileSize;
}