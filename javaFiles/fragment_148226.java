import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;

public class DoubleIterator implements Iterator<Double> {
    private Scanner scanner;

    public DoubleIterator(InputStream is) {
        scanner = new Scanner(is);

    }

    @Override
    public boolean hasNext() {
        return scanner.hasNextDouble();
    }

    @Override
    public Double next() {
        return scanner.nextDouble();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}