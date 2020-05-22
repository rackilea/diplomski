try (pw = new PrintWriter(file1)) {
   while (scanner.hasNextLine()) {
      line = scanner.nextLine();
      String s = new StringBuilder(line).reverse().toString();
      pw.println(s);
  }
}