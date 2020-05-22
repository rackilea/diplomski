class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger bi = sc.nextBigInteger();

        for (int i = 1; i <= 12; i++) {
            if (bi.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
    }
}