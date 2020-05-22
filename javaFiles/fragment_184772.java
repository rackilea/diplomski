public interface Worker {
  void work();
}

class A {
  void foo() { System.out.println("A"); }
}

class B {
  void bar() { System.out.println("B"); }
}

A a = new A();
B b = new B();

Worker[] workers = new Worker[] {
  new Worker() { public void work() { a.foo(); } },
  new Worker() { public void work() { b.bar(); } }
};

for (Worker worker : workers) {
  worker.work();
}