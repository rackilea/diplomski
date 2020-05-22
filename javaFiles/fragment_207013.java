private void setIfNotBlank(String value, Consumer<String> setter)  {
    setConditionally(value, setter, StringUtils::isNotBlank);
}

// if you don't need non-string arguments you can inline this method
private <T> void setConditionally(T value, Consumer<T> setter, Predicate<T> shouldSet) {
    if (shouldSet.test(value)) setter.accept(value);
}