private void writeObject(ObjectOutputStream os) {
  try {
    os.defaultWriteObject();
    os.writeInt(c.getSize());
    os.writeObject(c.getColor());
  } catch (Exception e) {
    // handle exception
  }
}

private void readObject(ObjectInputStream is) {
  try {
    is.defaultReadObject();
    int collarSize = is.readInt();
    String collarColor = (String) is.readObject();
    this.c = new Collar(collarColor, collarSize);
  } catch (Exception e) {
    // handle exception
  }
}