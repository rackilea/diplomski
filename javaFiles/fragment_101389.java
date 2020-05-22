public void myFunc(Class cls){
     //need to check that cls is a class which extends A
     //i.e. B, C and E but not A or D

     if (cls != A.class && A.class.isAssignableFrom(cls)) {
         // ...
     }
}