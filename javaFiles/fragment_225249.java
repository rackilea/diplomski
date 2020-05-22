abstract class A { 
  final void doSomething() { doSomethingSpecific() ... }
  abstract void doSomethingSpecific();
}

class B extends A { @Override void doSomethingSpecific() { ...