abstract class Thingy { ... }

  interface HTMLPrintable {
     public String toHTMLString();
  }         

  class Foo extends Thingy implements HTMLPrintable {
     ...
     public String toHTMLString() {
        ...
     }
  }

  class Bar extends Thingy implements HTMLPrintable {
     ...
     public String toHTMLString() {
        ...
     }
  }

  //We've added another class that isn't related to all of the above but is still HTMLPrintable,
  //with interfaces we can do this.
  class NotEvenAThingy implements HTMLPrintable { 
     public String toHTMLString() {
        ...
     }
  }