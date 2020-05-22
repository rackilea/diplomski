verify(mockAppender, times(2)).doAppend(logEventArgumentCaptor.capture());

assertThat(logEventArgumentCaptor.getAllValues().get(0).getMessage(),
    containsString("Error response: " + RESPONSE ));
assertThat(logEventArgumentCaptor.getAllValues().get(1).getMessage(),
    containsString("Request body: " + BODY));