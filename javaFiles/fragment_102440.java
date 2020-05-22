public static void calculate(BigInteger s, BigInteger t) {
    while (i < 4000000) {
        System.out.printf("%d\t%d\n", p, i);
        temp = p;
        p = p.add(q);
        q = temp;
        i++;
        // calculate(p, q); // you don't need this
    }
}