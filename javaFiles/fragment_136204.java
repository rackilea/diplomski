class ClassA{

    private ExternalObject externalObject;

    public ClassA() {
        super();
    }

    public ClassA(ExternalObject externalObject, String string) {
        super();
        this.externalObject = externalObject.parseString(string);
    }
}