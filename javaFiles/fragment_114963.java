import java.util.List;

public class PerfTest {
    interface Interface1<T> {}
    interface Interface2<T> extends Interface1<T> {}
    static class Bound {}
    interface BoundedI1<T extends Bound> extends Interface1<T> {}
    interface BoundedI2<T extends Bound> extends Interface2<T> {}
    static class Actual extends Bound {}

    public static void main(String[] args) {
        test((List<BoundedI2<Actual>>) null);
        test2((List<BoundedI2<Actual>>) null);
    }

    public static void test(List<? extends Interface2<? extends Bound>> list) { test2(list); }

    public static void test2(List<? extends Interface1<? extends Bound>> list) {}
}