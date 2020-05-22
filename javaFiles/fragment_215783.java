List<byte[]> keys = new ArrayList<>();

for (int b = -128; b <= 127; b++) {
  for (int c = -128; c <= 127; c++) {
    byte[] newValue = new byte[8];
    newValue[6] = (byte) b;
    newValue[7] = (byte) c;
    keys.add(newValue);
  } 
}