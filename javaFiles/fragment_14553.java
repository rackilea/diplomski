public class Prime {

    public static void main(String[] args) {
        BigInteger number = new BigInteger("2")
                .pow(74207281)
                .subtract(new BigInteger("1"));
        System.out.println(number);
    }

}