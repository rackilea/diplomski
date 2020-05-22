private void appendToFile(String str) {
  File file = getFileStreamPath("test.txt");
  if (!file.exists()) {
    file.createNewFile();
  }
  FileOutputStream writer = openFileOutput(file.getName(), MODE_APPEND | MODE_WORLD_READABLE);
  writer.write(str.getBytes());
  writer.flush();
  writer.close();
}