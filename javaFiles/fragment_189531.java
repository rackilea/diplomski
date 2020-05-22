@Test
public void push_PointerSmallerThanCapacity_ExceptionThrow(){
    String inputString  = "Hello";
    yourObject.push(inputString);
    int pointer = WhiteBox.getInternalState(yourObject,"pointer");
    String[] objects = WhiteBox.getInternalState(yourObject,"objects");

    assertEquals(inputString, objects[pointer-1]);
}