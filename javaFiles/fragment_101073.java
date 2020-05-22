@Immutable
class Foo { 
  final int a, b; 
  Foo(final int a; final int b) { this.a = a; this.b=b; }
}

static final Object FooSync theFooSync = new Object();

@GuardedBy("theFooSync");
static Foo theFoo;

void updateFoo(final int newA, final int newB) {
  f = new Foo(newA,newB);
  synchronized (theFooSync) {theFoo = f;}
}
void readFoo() {
  final Foo f;
  synchronized(theFooSync){f = theFoo;}
  // use f...
}