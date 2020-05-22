@Produces
MyAbstractClass getMyAbstractClass(MyOneClass class1, MyTwoClass class2) {
   if (...) {
      return class1;
   }
   return class2;
}