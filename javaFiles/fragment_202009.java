grammar T;

@header {
  // Code will be placed outside the parser class
  static class JavaClass {
    public String getValue() {
      return "TODO";
    }
  }
}

@members {
  // Code will be placed inside the parser class
  private final JavaClass javaClass = new JavaClass();
}

parse
 : block EOF
 ;

block
 : stat+ {System.out.println(javaClass.getValue());}
 ;

stat
 : ...
 ;