public class Test {
    public static void main(String[] args) {
        calculateTotal(100, 20);
    }

    private static void calculateTotal(int preTaxTotal, int tax) {
        int totalIncludingTax = preTaxTotal + tax;
        System.out.println("Total amount: " + totalIncludingTax);
    }
}