while (zis.getNextEntry() != null) {
  DataInputStream dis = new DataInputStream(new BufferedInputStream(zis));
  boolean done = false;
  do {
    short s = dis.readShort();
    int i = dis.readInt();
    ...
  } while (!done);
}