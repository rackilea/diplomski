public void run() {
  try {
    while (true) {
      String line = input.readLine();
      if (line == null)
        break;
      /* Process line. */
      ...
    }
  } catch (IOException ex) {
    /* Handle the exception as desired. */
    ex.printStackTrace();
  }
}