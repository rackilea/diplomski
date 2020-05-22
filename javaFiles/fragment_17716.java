@Test
public void getserviceTest () {
    QAService qasmock = mock(QAService.class);
    when(qasmock.getServiceInfo()).thenReturn("50");
    String expected = "50";
    assertEquals(expected, qasmock.getServiceInfo());
}