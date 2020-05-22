import java.util.Iterator;
import java.util.Random;

public class NoiseIterator implements Iterator<Double> {
    Random r = new Random();
    private Iterator<Double> source;

    public NoiseIterator(Iterator<Double> source) {
        this.source = source;
    }

    @Override
    public boolean hasNext() {
        return source.hasNext();
    }

    @Override
    public Double next() {
        return source.next()+r.nextGaussian();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}