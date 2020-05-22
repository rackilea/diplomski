public class ReorderingBench {

    public int[] array = new int[] {1 , -1,  1, -1};
    public int sum = 0;

    @Benchmark
    public void reorderGlobal() {
        int[] a = array;
        sum += a[1];
        sum += a[0];
        sum += a[3];
        sum += a[2];
    }

    @Benchmark
    public int reorderLocal() {
        int[] a = array;
        int sum = 0;
        sum += a[1];
        sum += a[0];
        sum += a[3];
        sum += a[2];
        return sum;
    }
}