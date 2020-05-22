when(foo.bar(any())).thenAnswer(invocation -> {
    for (Object argument : invocation.getArguments()) {
        if ("AAA".equals(argument)) return true;
    }
    return false;
});