case SerialPortEvent.DATA_AVAILABLE:
  String line;
  BufferedReader br = null;
  try (br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));) {
    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }
  } catch (IOException e) {
    e.printStackTrace();
  }