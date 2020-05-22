@Test
public void testChangeRadioState() {
    WebElement mockElement           = mock(WebElement.class);
    WebElement selectedMockElement   = mock(WebElement.class);
    List<WebElement> mockElementList = new ArrayList<>();

    /*The when statements*/
    when(selectedMockElement.isSelected()).thenReturn(true);
    // By default mockito will return false but maybe I want to highlight 
    // that this is important
    when(mockElement.isSelected()).thenReturn(false);

    /*Add a selected and a none selected element to the list*/
    mockElementList.add(mockElement);
    mockElementList.add(selectedMockElement);

    /*The method that is beeing tested*/
    elementSetter.changeRadioState(mockElementList);

    verify(selectedMockElement).click();
    // according to test method name I would add 
    // one more verification that something was dis-selected
}