public abstract class BasePrintable {
    protected abstract void printResponse();
    public void print() {
        // Print the common part
        printResponse();
        // Print more common parts
    }
}

public class FirstPrintable extends BasePrintable {
    protected void printResponse() {
        // first implementation
    }
}

public class SecondPrintable extends BasePrintable {
    protected void printResponse() {
        // second implementation
    }
}