public static void main(String[] args) {
    BigInteger n = BigInteger.ONE;
    BigInteger p = BigInteger.ONE;
    for(int i = 1;i <= 64;i++){
        n = n.add(n);
        p = p.add(n);
    }
    System.out.println(p);
}