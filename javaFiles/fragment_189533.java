@Test
public void pop_pointerGreaterThenZero_PopValue(){
    //set pointer
    WhiteBox.setInternalState(yourObject, "pointer",2);
    String[] stringList = {"String0","String1","String2"};
    //object array
    WhiteBox.setInternalState(yourObject, "objects",stringList);

    String actualOutput = yourObject.pop();
    assertEquals(actualOutput, stringList[1]);
}