int getInt(BufferedReader br) throws IOException {
  while (true) {
    try
    {
      return Integer.parseInt(br.readLine().trim());
    } catch(NumberFormatException e) {
      System.out.println("Please enter a whole number.");
    }
  }
}