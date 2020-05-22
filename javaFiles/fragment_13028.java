interface Interface2 { }

interface Interface1<T> {
  void method1(T t);
}

interface Interface3 extends Interface1<Interface2> { }

abstract  class BaseClass<P extends Interface1<Interface2>> 
     implements Interface2{
  P p;

  void method2() {
    p.method1(this);
  }
}

class Concrete extends BaseClass<Interface3> implements Interface2 { }