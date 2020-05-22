public static String fan(int i) {
    BigInteger a = BigInteger.ZERO;
    BigInteger b = BigInteger.ONE;
    if(i==0) return a.toString();

    for (int f = 1; f < i; f++) {
        BigInteger temp = b;
        b = a.add(b);
        a = temp;
    }
    return b.toString();
}

public static void main(String[] args)

{
    Scanner input = new Scanner(System.in);

    int x = input.nextInt();

    String i = fan(x);

    System.out.println(i);
}