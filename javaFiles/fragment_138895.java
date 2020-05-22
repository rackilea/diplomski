// Read the private key
try {
  entry.protectedPrivKey = new byte[dis.readInt()];
} catch (OutOfMemoryError e) {
  throw new IOException("Keysize too big");
}