// temp = cut
@Test
public void testMethodA_valid() {
    // given
    Temp spyTemp = Mockito.spy(temp);
    boolean expected = true;
    Mockito.doReturn(expected).when(spyTemp).methodB(Mockito.any(String.class)); 

    // when
    boolean actual = spyTemp.methodA("XYZ");

    // then (faster readable)       
    Mockito.verify(spyTemp, times(1)).methodB(any(String.class))
    Mockito.verifyNoMoreInteraction(<ALL YOUR MOCKS HERE>);
    Assert.assertEquals(expected, is(equalTo(actual)));
}