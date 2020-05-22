double[] in = { 22, 45, 69.5, 60 };
for (double d : in) {
    int v = (int) d;
    v -= v % 20;
    System.out.printf("%.1f --> %d%n", d, v);
}