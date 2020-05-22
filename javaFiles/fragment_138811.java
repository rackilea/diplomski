public interface Printable {
    void print();
}

public class Test {
    public Printable getPrintable() {
        return new PrintTest();
    }

    private class PrintTest implements Printable {
        public void print() {
        }
    }
}

Test test = new Test();
test.getPrintable().print();