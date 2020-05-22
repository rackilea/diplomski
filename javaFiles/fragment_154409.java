public abstract class AbstractCalc {
    public abstract void increment (int by);
}

public class SingleIntCalc extends AbstractCalc {
    int value = 0;

    @Override
    public void increment(int by) {
        value+=by;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

public class MultiIntCalc extends AbstractCalc {

    private List<Integer> ints = new ArrayList<Integer>();

    @Override
    public void increment(int by) {
        for (int i = 0; i <ints.size(); i++) {
            int value = ints.get(i);
            ints.set(i, (value+by));
        }
    }

    public List<Integer> getInts() {
        return ints;
    }

    public void setInts(List<Integer> ints) {
        this.ints = ints;
    }

}