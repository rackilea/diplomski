class A { 
//defaulut argumentless constructor is implicitly created
}

class B extends A {
  B(int x) { 
      super(); //invoking super()
      //rest of construction
  }
}