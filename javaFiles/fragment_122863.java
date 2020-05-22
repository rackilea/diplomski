public class SomeSynchronizedClass {

    private Integer field1;
    private Double field2;
    ....

    public void doSomethingWithField1() {
        synchronized(field1) {
            // do something to field1 here
        }
    }

    public void doSomethingWithField2() {
        synchronized(field2) {
            // do something to field2 here
        }
    }
}