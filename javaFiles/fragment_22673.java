public int readNumber(File f) throws IOException, NumberFormatException {
  BufferedReader br = new BufferedReader(new
    InputStreamReader(new FileInputStream(f), "ASCII"));
  try {
    return Integer.parseInt(br.readLine());
  } finally {
    try { br.close(); } catch (IOException e) {
      // possibly log e
    }
  }
}