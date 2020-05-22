try {
   badOperation();
   /// looks like we succeeded. Not good! Fail the test
   fail();
}
catch (ExpectedException e) {
   // that's fine
}
catch (UnexpectedException e) {
   // that's NOT fine. Fail the test
}