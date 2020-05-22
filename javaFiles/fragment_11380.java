public Object deserialize(InputStream is) {
    ObjectInputStream in;
    Object obj;
    try {
      in = new ObjectInputStream(is);
      obj = in.readObject();
      in.close();
      return obj;
    }
    catch (IOException ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
    catch (ClassNotFoundException ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }