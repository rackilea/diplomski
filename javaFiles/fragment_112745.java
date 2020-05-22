private static int[] encrypt(FileInputStream file, String key) {
  int fileSize = file.getChannel().size();
  int[] output = new int[fileSize];

  int read = 0;
  int offset = 0;
  byte[] buffer = new byte[1024];
  while((read = file.read(buffer)) > 0) {
    for(int i = 0; i < read; i++) {
      char char1 = (char) buffer[i];
      int o = (char1 ^ Integer.valueOf(key.charAt(i % (key.length() - 1)))) + '0';
      output[i + offset] = o;
    }
    offset += read;
  }
  return output;        
}