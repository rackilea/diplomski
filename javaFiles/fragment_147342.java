class Foo { 
  def List l;
}


new Foo().l = new ArrayList()  // this works
new Foo().l = "ddd"  // this throws a GroovyCastException