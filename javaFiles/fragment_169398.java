Answer<Object> returnsFirstString =
        invocationOnMock -> Arrays.stream(invocationOnMock.getArguments())
                .filter(String.class::isInstance)
                .findFirst()
                .orElse(null);

translator = mock(Translator.class, returnsFirstString);