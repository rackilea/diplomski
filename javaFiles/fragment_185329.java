class ClassB extends ClassA {
    private final Foo copyOfInput;

    ClassB(Foo input) {
        super(input = input.clone());
        copyOfInput = input;
    }
}