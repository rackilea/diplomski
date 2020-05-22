public class Math {
    public static int add(int a, int b) { return a + b; }

    @Deprecated
    public static int randomNumber() { return 12; }
}

public class Random {
    public static int randomNumber(int upperBound) { return /* some complex implementation */; }
}