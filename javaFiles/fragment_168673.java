@Test
public void myUnitTest() {
    // Given
    MyPojo fixture = new MyPojo();

    LoggingService mockService = Mockito.mock(Logging.Service);

    Mockito.doNothing().when(mockService).fetchLogs(Mockito.any());

    fixture.setLoggingService(mockService);

    // When
    fixture.logSomethingToGAELogs("Some string to log");

    // Then - verify
    Mockito.verify(mockService).fetchLogs("Some string to log");
}