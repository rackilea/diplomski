class SubClass extends BaseClass{
    private SubObject subObject;

    public SubClass() {
        this(new SubObject());
    }

    private SubClass(SubObject subObject) {
        super(new SomeObject(subObject));
        this.subObject = subObject;
    }
}