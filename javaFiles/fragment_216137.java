class Foo
{
 private int bar; 

 public Foo() {
      this(42); // invoke parameterized constructor
 }

 public Foo(int bar) {
     this.bar = bar; // disambiguate 
 }

 public void frob() {
      this.baz(); // used "just because"
 }

 private void baz() {
      System.out.println("whatever");
 }

}