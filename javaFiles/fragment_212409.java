private int mResult;

@Test
public void f1() {
  mResult = ...
}

@Test(dependsOnMethods = "f1")
public void f2() {
  // use mResult
}