@Test
public void tryThrowExceptionForInvalidRequest() throws Exception {

    final String invalid = "Este es un request invalido";

    InvalidInputRequestType exceptionThrown = Assertions.assertThrows(
                InvalidInputRequestType.class,
                () -> { 
                    detector.detectForRequest(invalid); 
                }
        );
    assertEquals(invalid, exceptionThrown.getMessage());
}