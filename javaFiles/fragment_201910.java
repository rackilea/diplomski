try {
   fixture.myMethod("should throw");
   fail("Expected an exception");
} catch (MyException e) {
   // expected  
}