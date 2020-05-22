public void myMethod(@Valid MyValidationAnnotatedType parameter){
    ...
}

public void anotherMethod(@Pattern(regex = "^[A-Za-z]+$") stringParameter) {
    ...
}