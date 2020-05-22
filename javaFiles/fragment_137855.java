public Parser(String file) throws IOException {
    try (PrintWriter out = new PrintWriter(System.getProperty("user.dir") + "...")) {

        System.out.println("Initiated Parser class!");
        out.println(parseFile(file));

     }
  }