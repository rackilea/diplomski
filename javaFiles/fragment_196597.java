BigDecimal bd = BigDecimal.ZERO;
long l = 0;
double d = 0;
while (true) {
    for (int i = 0; i < 100000000; i++) {
        bd = bd.add(BigDecimal.ONE);
        l++;
        d++;
    }
    System.out.println("counting bd: " + bd + " l: " + l + " d:" + d);
}