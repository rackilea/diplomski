class Foo { 
  // it turns out these fields may not be final, with the volatile publish, 
  // the values will be seen under the new JMM
  final int a, b; 
  Foo(final int a; final int b) 
  { this.a = a; this.b=b; }
}

// without volatile here, separate threads A' calling readFoo()
// may never see the new theFoo value, written by thread A 
static volatile Foo theFoo;
void updateFoo(int newA, int newB) {
  f = new Foo(newA,newB);
  theFoo = f;
}
void readFoo() {
  final Foo f = theFoo;
  // use f...
}