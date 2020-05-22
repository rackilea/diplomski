FileInputStream fstream = new FileInputStream(fileName);
try {
  ObjectInputStream ostream = new ObjectInputStream(fstream);
  while (ostream.available() > 0) {
    Object obj = ostream.readObject();
    // do something with obj
  }
} finally {
  fstream.close();
}