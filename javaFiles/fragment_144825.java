grammar T;

@header {
  import java.io.PrintWriter;
}

@members {
  PrintWriter writer;

  public TParser(TokenStream input, String fileName) {
    super(input);
    try {
      writer = new PrintWriter(fileName);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}

parse
  :  numbers EOF
  ;

numbers
  :  (NUM {
            writer.println("parsed: " + $NUM.text);
            writer.flush();
          }
     )+
  ;

NUM : '0'..'9'+;
WS  : ' ' {skip();};