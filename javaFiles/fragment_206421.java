// code 2
SomeObject myObj = new SomeObject();
myObj.doSomething();

// bytecode 2
   0:   new #2; //class SomeObject
   3:   dup
   4:   invokespecial   #3; //Method SomeObject."<init>":()V
   7:   astore_1
   8:   aload_1
   9:   invokevirtual   #4; //Method SomeObject.doSomething:()V
   12:  return