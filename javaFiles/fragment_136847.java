public Interface ICustomSerializable {
  void writeObject(DataOutputStream dos);
  Object readObject(DataInputStream dis);
}

public Class Foo {
  public static final VERSION_V1 = 1;
  public static final VERSION_V2 = 2;

  public static final CURRENT_VERSION = VERSION_V2;
  private int version;

  private int fooNumber;
  private double fooDouble;

  public void writeObject(DataOutputStream dos) {
     dos.writeInt(this.version);
      if (version == VERSION_V1) {
          writeVersionV1(dos);
      } else (version == VERSION_V2) {
          writeVersionV2(dos);
      } else {
         throw new IllegalFormatException("unkown version: " + this.version);
      }
  }
  public void writeVersionV1(DataOutputStream dos) {
        writeInt(this.fooNumber);
        writeDouble(this.fooValue);
  }
}