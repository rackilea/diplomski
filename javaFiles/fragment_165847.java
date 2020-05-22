TestClass(TestClass1[] tc1, String attrName){

    tc = tc1;
    this.attrName = attrName; 
    if (tc != null) {
      tc2 = new TestClass2[tc.length];
      for(int i = 0; i< tc.length; i++) {
        TestClass2 t2c = new TestClass2(tc[i].getElements()); //this.tc.elements will   return an Array of SomeClass which is not implemented by me.
        tc2[i] = t2c;
      }
   }
}

/**
 * Returns the Testclass2 Array
 */
public TestClass2[] getTestClass2(){

  //What to do ?? 
  return tc2;
}

class TestClass2 {
   /**
    * Default constructor
    */ 
   TestClass2(){}