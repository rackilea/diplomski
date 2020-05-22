public class Foo {
    private String value;

    public Foo(String v) {
        this.value = v;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String v) {
        this.value = v;
    }
 }

 // ....
 public void method(String in, Foo inOut) {
     inOut.setValue(in);
 }