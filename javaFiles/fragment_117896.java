public ObjectInputStream(InputStream in) throws IOException {
     verifySubclass();
     bin = new BlockDataInputStream(in);
     handles = new HandleTable(10);
     vlist = new ValidationList();
     enableOverride = false;
     readStreamHeader(); //this is whats causing it to block
     bin.setBlockDataMode(true);
}


protected void readStreamHeader() throws IOException, StreamCorruptedException {
     short s0 = bin.readShort();
     short s1 = bin.readShort();
     if (s0 != STREAM_MAGIC || s1 != STREAM_VERSION) {
          throw new StreamCorruptedException(String.format("invalid stream header: %04X%04X", s0, s1));
     }
}