public class Test {

    public static void main (String[] args) {
        PrintNumbers pn = new PrintNumbers(0);
        DoubleDecoratorCount decorator = new DoubleDecoratorCount(pn);
        for (int i = 0 ; i < 5 ; ++i)
            System.out.println("value: " + decorator.getNextNumber());
    }
}