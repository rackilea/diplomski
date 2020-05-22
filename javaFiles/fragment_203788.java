class A{ //Parenthesis are NOT needed
         // or allowed in class definition:
         // 'class A()' is wrong
 String b;
 public void c(){
  //some code in here
 }
}

 class C{ //Same here. No parenthesis needed
  A a = new A(); //Q: Is this ok and if it is ok what is this mean??
                 //A: Yes, completely ok.
                 // This means you added
                 // a field 'a' of type A to the class C

 public void p(){
  a.c(); //Q: Is this possible??
         //A: Of course
 }
}