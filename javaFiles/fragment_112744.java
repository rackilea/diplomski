private static int[] encrypt(FileInputStream file, String key) {
  int fileSize = file.getChannel().size();
  int[] output = new int[fileSize];
  for(int i = 0; i < output.length; i++) {
    char char1 = (char) file.read();
    int o = (char1 ^ Integer.valueOf(key.charAt(i % (key.length() - 1)))) + '0';
    output[i] = o;
  }
  return output;        
}