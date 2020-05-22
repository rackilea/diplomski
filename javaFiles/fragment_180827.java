public void getFileFor(String filename) {
  File newFile = File(filename);
  File inList = fileHashMap.putIfAbsent(newFile);
  if (inList != null) {
    return inList;
  } else {
    return newFile;
  }
}