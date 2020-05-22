public static void main(String[] args) throws Exception {
  ProcessBuilder pb = new ProcessBuilder("cmd", "/c",
                                      "C:\\Users\\robert\\Desktop\\notepad.lnk");
  Process p = pb.start();
  p.waitFor();
}