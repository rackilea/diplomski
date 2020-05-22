File dir = new File(folder);

if (dir.exists()) {

  //list out all the file name with .txt extension
  String[] list = dir.list(filter);

  ...
}