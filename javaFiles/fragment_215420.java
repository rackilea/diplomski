public class Test {
    public static void main(String[] args) {
        int x = 5;
        double y = 10;
        System.out.println(getDoubleValue(x, y));
    }

    private static double getDoubleValue(Number x, Number y){
        return x.doubleValue() + y.doubleValue();
    }
}