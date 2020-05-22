public class Test {
    interface Sample<T>{}
    @SuppressWarnings("unchecked")
    public static <T> Sample<T>[] sampleArray() {
        return new Sample[2];
    }
}