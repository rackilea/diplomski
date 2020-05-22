public class Ques11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double d = scan.nextInt(); // Note we're assigning to a double
        BigDecimal sum = new BigDecimal(1);
        for(int i = 2; i <= d; i++) {
            sum.add(new BigDecimal(1.0/d));
        }
        System.out.print(sum.setScale(10).toPlainString());
    }
}