class SomeTPLClass {
    public SomeTPLClass(String id) {
    }
}

class SomeTPLClassProducer {
    @Produces
    public SomeTPLClass getInstance() {
        return new SomeTPLClass("");
    }
}