ArgumentCaptor<Callback> captor = ArgumentCaptor.forClass(Callback.class);
when(mockService.fetchString(captor.capture()).thenReturn("return string");

String answer = mockService.fetchString(callbackToTest);
// callback is invoked after the service method returned the value
captor.getValue().onResult("callback string");

assertEquals("return string", answer);
verify(callbackToTest).onResult(eq("callback string"));