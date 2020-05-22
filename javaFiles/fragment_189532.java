@Test(exception = IllegalArgumentException.class)
public void pop_PointerNegative_ExceptionThrow(){
    WhiteBox.setInternalState(yourObject, "pointer",-1);
    String inputString  = "Hello";
    yourObject.push(inputString);
}