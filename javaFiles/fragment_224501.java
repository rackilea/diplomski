@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 5)
public class ExampleBench {

    @Param("10000")
    private int count;

    List<Integer>[] arrays;
    List<Integer>[] empty;
    List<Integer>[] bimorphic;
    List<Integer>[] polimorphic;

    @Setup
    public void setup(){
        Random r = new Random(0xBAD_BEEF);
        arrays = new List[count];
        empty = new List[count];
        bimorphic = new List[count];
        polimorphic = new List[count];
        for (int i = 0; i < arrays.length; i++) {
            bimorphic[i] = r.nextBoolean() ? new ArrayList<Integer>(0) : Collections.<Integer>emptyList();
            int i1 = r.nextInt(3);
            switch (i1) {
                case 0 : polimorphic[i] = new ArrayList<>(0);
                    break;
                case 1 : polimorphic[i] = new LinkedList<>();
                    break;
                case 2 : polimorphic[i] = Collections.emptyList();
                    break;
            }
            arrays[i] = new ArrayList<>(0);
            empty[i] = Collections.emptyList();
        }
    }

    @Benchmark
    public float arrayList() {
        List<Integer>[] l = arrays;
        int c = count;
        float result = 0;
        for (int i = 0; i < c; i++) {
            result += sum(l[i]);
        }
        return result;
    }

    @Benchmark
    public float emptyList() {
        List<Integer>[] l = empty;
        int c = count;
        float result = 0;
        for (int i = 0; i < c; i++) {
            result += sum(l[i]);
        }
        return result;
    }

    @Benchmark
    public float biList() {
        List<Integer>[] l = bimorphic;
        int c = count;
        float result = 0;
        for (int i = 0; i < c; i++) {
            result += sum(l[i]);
        }
        return result;
    }

    @Benchmark
    public float polyList() {
        List<Integer>[] l = polimorphic;
        int c = count;
        float result = 0;
        for (int i = 0; i < c; i++) {
            result += sum(l[i]);
        }
        return result;
    }

    int sum(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); ++i) {
            sum += list.get(i);
        }
        return sum;
    }
}