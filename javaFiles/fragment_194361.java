public enum SomeEnum{
    A(true),
    B(false),
    C(true),
    D(false);

    private boolean myBool;

    private SomeEnum(boolean myBool){
        this.myBool = myBool;
    }

    public boolean geMyBool() {
        return myBool;
    }
}