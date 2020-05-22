class A {
     List<String> copy;
     //constructor
     public A() {
       copy = new ArrayList<>();
       //Some calculation and the value of copy is now holding some information
     }
}

class B extends A {
     List<String> paste;
     //constructor
     public B() {
       super(); //calls the A constructor and fills copy
       paste = new ArrayList<>(copy);
     }
}