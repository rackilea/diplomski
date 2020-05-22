class MyBlob implements Serializable {

  byte[] myBlobField;

  //Setter
  public void setMyBlobField(byte[] myBlobField) {
    this.myBlobField = myBlobField;
  }

  //Getter
  public byte[] getMyBlobField() {
     return myBlobField;
  }
}