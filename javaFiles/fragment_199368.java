try {
  File file = myFrame.showSaveDialog(); // if this method returns a File!!!!!
  FileOutputStream fos = new FileOutputStream(file, true);
  PrintStream printStream = new PrintStream(fos);
  //.... etc
} catch(....) {
  // ....
}