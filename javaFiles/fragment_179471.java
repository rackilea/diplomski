class Thingy {
    private int someNumber;
    private String someString;
    private boolean someBool;
    private String someOtherString;

    public Thingy(int _someNumber, String _someString, boolean _someBool, String _someOtherString) {
        this.someNumber = _someNumber;
        this.someString = _someString;
        this.someBool = _someBool;
        this.someOtherString = _someOtherString;
    }

    public int getSomeNumber() {
        return this.someNumber;
    }
    // ...setter if appropriate...

    // ...add accessors for the others...
}