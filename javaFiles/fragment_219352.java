@SuppressWarnings("unchecked")
void myMethod() {
    // ... code here ...

    ((List<Object>) methodVal).addAll((Collection<?>) Objects.requireNonNull(someValue));

    // ... code here ...
}