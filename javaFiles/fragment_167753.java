class Helper {
  private BufferedReader in;

  Helper(String infile) {
    this.in = new BufferedReader(new FileReader(infile));
  }

  char getChar() {
    try {
      return in.read();
    } catch (IOException e) {
       System.out.println( e.getMessage() );
       System.exit(1);
    }
  }

  void close() {
    this.in.close();
  }
}

class Other {
  void something(String infile) {
    Helper helper = new Helper(infile);
    char newChar = helper.getChar();
    char anotherNewChar = helper.getChar();

    helper.close();
   }
}