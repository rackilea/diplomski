class Outer
  {
      class Inner
      {
        // field declaration and other code
      }
  }
  //...........
  Outer outerObj = new Outer();
  Outer.Inner innerObj = outerObj.new Inner(); // instance creation of inner class

  Outer.Inner[] innrArr = new Outer.Inner[5]; // array creation of inner class