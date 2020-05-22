verify(mockAppender)
    .doAppend(argThat(isALogEventContaining("Error response: " + RESPONSE)));
verify(mockAppender, never())
    .doAppend(argThat(isALogEventContaining("Request body: " + BODY)));
when(mockAppender.doAppend(argThat(isALogEventContaining("Foo"))))
    .thenThrow(new RuntimeException("Log not available"));