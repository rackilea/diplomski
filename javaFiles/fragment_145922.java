Foo copyFoo (Foo foo){
  Foo f = new Foo();
  //for all properties in FOo
  f.set(foo.get());
  return f;
}