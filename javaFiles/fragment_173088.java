when(mockService.search(argThat(hasValue("123")), booleanThat(isTrue()))).thenReturn("something");

// ...

private AnyBooleanMatcher isTrue() {
    return new AnyBooleanMatcher();
}

private MyObjectMatcher hasValue(String value) {
    return new MyObjectMatcher(value);
}