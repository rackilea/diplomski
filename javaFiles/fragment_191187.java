public class Sum implements Comparable {
    public long currentSum;
    public boolean isRow;
    public int index;

    public Sum(long sum, boolean row, int i) {
        currentSum = sum;
        isRow = row;
        index = i;
    }

    public Sum(Sum s) {
        currentSum = s.currentSum;
        isRow = s.isRow;
        index = s.index;
    }

    @Override
    public int compareTo(Object o) {
        Sum s = (Sum)o;
        return  Long.compare(this.currentSum, s.currentSum);
    }
}