@Bean
Foo foo(Bar bar){
     Foo foo = new Foo();
     foo.method(bar);      // Or whatsoever...
     return foo;
}