ByteArrayOutputStream baos = new ByteArrayOutputStream();
DataOutputStream dos = new DataOutputStream(baos);
int[] ints = new int[] { 128, 36000, 129, 36000 };
try {
  for (int i = 0; i < ints.length; i += 2) {
    dos.writeByte(ints[i]);
    dos.writeInt(ints[1 + i]);
  }
  dos.close();
} catch (IOException e) {
  e.printStackTrace();
}
byte[] bytes = baos.toByteArray();