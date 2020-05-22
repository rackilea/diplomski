class A {
     doStuff() {
         console.log("hello world");
     }
}

class B extends A {
     doStuff() {
         super.doStuff();
         console.log("...and goodbye!");
     }
}