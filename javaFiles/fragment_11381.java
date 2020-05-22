public void serialize(Object obj, String fileName) {
    FileOutputStream fos;
    ObjectOutputStream out;
    try {
      fos = new FileOutputStream(fileName);
      out = new ObjectOutputStream(fos);
      out.writeObject(obj);
      out.close();
    }
    catch (IOException ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }