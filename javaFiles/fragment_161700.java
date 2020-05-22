class Bar {
    public String toString() {
        return "bar";
    }
}

class Foo extends Bar{
      String foo = "foo";
      public Foo(){
           super();        //what purpose of this?
      }
      public String toString() {
          super.toString()
}