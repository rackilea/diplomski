interface InterfaceFOO {}   // <------------ Marker without methods

interface Interface2 extends InterfaceFOO{ } // <----- harmless extend

interface Interface1<T> {
   void method1(T t);
}

interface Interface3 extends Interface1<InterfaceFOO> { }

abstract  class BaseClass<P extends Interface1<InterfaceFOO>> 
     implements InterfaceFOO{
  P p;

  void method2() {
    p.method1(this);
  }
}

class Concrete extends BaseClass<Interface3> implements Interface2 { }