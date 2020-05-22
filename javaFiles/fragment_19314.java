public class Foo implements MyWrapper {
    private String myField;

    public Foo() {}
    public Foo(String f) {
        setMyField(f);
    }

    @Override
    public String getMyField() {
        return myField;
    }

    @Override
    public void setMyField(String f) {
        myField = f;
    }
}