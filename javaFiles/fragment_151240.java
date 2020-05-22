public class FooCalculator implements Calculator<FooCalculator.Settings> {
    ...
    public static class Settings {
        public final int param1;
        public final double param2;
        ...
    }
}