public interface UnitValue {
    boolean isLast();
    UnitValue next();
}

public class <T extends UnitValue> MultiUnitValue {
    private final int size;
    private final T first;
    private final T[] units;
    private boolean complete = false;

    public MultiUnitValue(int size, T first) {
        this.size = size;
        this.first = first;
        this.units = new T[size];
        for (int i = 0; i < size; i++)
            units[i] = first;
    }

    public void next() {
        if (!complete) {
            int i = 0;
            while (units[i].isLast())
                units[i++] = first;
            units[i].next();
            complete = i == size - 1 && units[i].isLast();
        }
    }
}