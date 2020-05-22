public List<List<File>> fileSplit(File [] files, long maxAttachmentSize) {
  long totalAttachmentSize = 0;

  List<List<File>> allLists = new ArrayList<>();

  List<File> currList = new ArrayList<File>();
  allLists.add(currList);
  for (File file : files) {
    long fileSize = file.length();
    if ((totalAttachmentSize + fileSize) <= maxAttachmentSize) {
      currList.add(file);
      totalAttachmentSize += fileSize;
    } else {
      totalAttachmentSize = fileSize;
      currList = new ArrayList<File>();
      allLists.add(currList);
      currList.add(file); // assuming no file is bigger than maxAttachmentSize
    }
  }

  return allLists;
}