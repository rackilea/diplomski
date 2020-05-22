@Test
public void testMethod_notThisString(){
    whenever(helperObject.obtainAString()).thenReturn(HelperObject.CONSTANT1, HelperObject.CONSTANT2, HelperObject.CONSTANT3);
    instantiatedClass.method()
    verify(someOtherObjectWithAMethod).thisMethod("differentarg");
}