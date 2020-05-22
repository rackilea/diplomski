byte[] header = new byte[8192];
//reads entire array or until EOF whichever is first
bis.read(header);

if(isFileType(header)) {
  byte[] finalBytes = inputStreamToByteArray(bis);
  methodForFinalBytes(finalBytes);
} else {
  // Do other stuff;
}