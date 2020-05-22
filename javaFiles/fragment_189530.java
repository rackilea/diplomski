@Test(exception = IllegalArgumentException.class)
public void push_PointerGreaterThanCapacity_ExceptionThrow(){
    WhiteBox.setInternalState(yourObject, "pointer",11);
    String inputString  = "Hello";
    yourObject.push(inputString);
}