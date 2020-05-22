boolean selected;
@Test
public void testChangeRadioState() {
    selected = false;
    WebElement mockElement           = mock(WebElement.class);
    WebElement selectedMockElement   = mock(WebElement.class);
    List<WebElement> mockElementList = new ArrayList<>();

    /*The when statements*/
    when(selectedMockElement.isSelected()).thenReturn(true);
    doAnswer(new Answer<Object>() {
        public Object answer(InvocationOnMock invocation) {
            selected = true;
            return null;
        }
    }).when(mockElement).click();
    /*Add a selected and a none selected element to the list*/
    mockElementList.add(mockElement);
    mockElementList.add(selectedMockElement);

    /*The method that is beeing tested*/
    elementSetter.changeRadioState(mockElementList);

    Assert.assertTrue("The radio state was not selected", selected);
    // according to test method name I would add 
    // one more verification that something was dis-selected
}