when(mock.foo(anyString(), anyObject())).thenAnswer(
    invocation -> {
        Object argument = invocation.getArguments()[1];
        if (argument.equals(new ARequest(1, "A"))) {
            return new AResponse(1, "passed");
        } else if (argument.equals(new ARequest(2, "2A"))) {
            return new AResponse(2, "passed");
        } else if (argument.equals(new BRequest(1, "B"))) {
            return new BResponse(112, "passed");
        }
        throw new InvalidUseOfMatchersException(
            String.format("Argument %s does not match", argument)
        );
    }
);