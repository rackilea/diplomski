FileInputStream fstream = new FileInputStream(fileName);
try {
  ObjectInputStream ostream = new ObjectInputStream(fstream);
  while (true) {
    Object obj;
    try {
      obj = ostream.readObject();
    } catch (EOFException e) {
      break;
    }
    // do something with obj
  }
} finally {
  fstream.close();
}