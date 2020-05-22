interface Incrementable { public void increment(); }
interface HasScore { public int getScore(); }
class C implements Incrementable, HasScore { /* ... */ }

class A {
  public A(Incrementable incr) { /* ... */ }
}

class B {
  public B(HasScore hs) { /* ... */ }
}