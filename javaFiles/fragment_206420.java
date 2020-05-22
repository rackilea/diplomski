// code 1
new SomeObject().doSomething();

// bytecode 1
   0:   new #2; //class SomeObject
   3:   dup
   4:   invokespecial   #3; //Method SomeObject."<init>":()V
   7:   invokevirtual   #4; //Method SomeObject.doSomething:()V
   10:  return