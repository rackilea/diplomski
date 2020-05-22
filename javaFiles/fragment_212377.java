public void someMethod() {
   MyObject myObject = new MyObject();
   myObject.doSomething();  //last use of myObject in this scope
   myObject = null; //Now available for gc
   doAnotherThing();
   andEvenMoreThings();
}