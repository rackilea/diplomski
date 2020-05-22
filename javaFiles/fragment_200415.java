public abstract class FilterData<T extends Number> {
    private final Queue<T> mFilter = new LinkedList<T>();
    protected Integer mSize;

    public FilterData() {
        this(10);
    }

    public FilterData(int size) {
        mSize = size;
    }

    public double filter(T currentVal) {
        push(currentVal);

        double totalVal = 0d;
        int numNonZeros = 0;
        for (T value : mFilter) {
            if (value.doubleValue() != 0) {
                ++numNonZeros;
                totalVal += value.doubleValue();
            }
        }

        return totalVal / numNonZeros;
    }

    public void push(T currentVal) {
        mFilter.add(currentVal);
        if (mFilter.size() > mSize)
            mFilter.remove();
    }

    public void resizeFilter(int newSize) {
        if (mSize > newSize) {
            int numItemsToRemove = mSize - newSize;
            for (int i = 0; i < numItemsToRemove; ++i) {
                mFilter.remove();
            }
        }
        mSize = newSize;
    }
}