public Parser(String file) throws IOException {
    PrintWriter out = new PrintWriter(System.getProperty("user.dir") + "...");
    System.out.println("Initiated Parser class!");

    out.println(parseFile(file));
  }