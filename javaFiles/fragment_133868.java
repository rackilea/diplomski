ClassA a = new ClassA() {//extend class A

 InterfaceB methodA() {//Override methodA
    return new ClassB() {//extend class B
       void methodB() {//Override methodB
       //...
       }
    };
  }
};