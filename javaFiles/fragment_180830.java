public class FooClass implements FooInterface {

    // DISCRIMINATOR FIELD
    private final String className;

    private String field1;

    private String field2;

    public FooClass() {
        this.className = getClass().getName();
    }

    public String getClassName() {
        return className;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

}