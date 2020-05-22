/**
  * Convert byte[] raw audio to 16 bit int format.
  * @param rawdata
  */
private int[] byteToShort(byte[] rawdata) {
  int[] converted = new int[rawdata.length / 2];

  for (int i = 0; i < converted.length; i++) {
    // Wave file data are stored in little-endian order
    int lo = rawdata[2*i];
    int hi = rawdata[2*i+1];
    converted[i] = ((hi&0xFF)<<8) | (lo&0xFF);
  }
  return converted;
}
private float[] byteToFloat(byte[] audio) {
  return shortToFloat(byteToShort(audio));
}