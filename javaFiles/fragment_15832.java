public static boolean isExecutable(File file) {
  byte[] firstBytes = new byte[4];
  try {
    FileInputStream input = new FileInputStream(file);
    input.read(firstBytes);

    // Check for Windows executable
    if (firstBytes[0] == 0x4d && firstBytes[1] == 0x5a) {
      return true;
    }
    return false;
  }
  catch (Exception e) {
    e.printStackTrace();
  }
}