ResponseEntity<Object> expectedReturnValue = ...

RestOperations testClient = mock(RestOperations.class);
doReturn(expectedReturnValue).when(testClient).postForEntity(any(), any(), anyClass());

EncoderService service = new EncoderService(testClient);
// use the service