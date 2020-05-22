int var0, var1, var2;
int n = 4;
System.out.println("   i | Assignment");
System.out.println("-----+-----------");
for (int i = 0; i < Math.pow(n, 3); ++i) {
    var0 = i % n;           // = i / Math.pow(n, 0) % n 
    var1 = i / n % n;       // = i / Math.pow(n, 1) % n 
    var2 = i / (n * n) % n; // = i / Math.pow(n, 2) % n
    System.out.format("%4d | %2d %2d %2d\n", i, var2, var1, var0);
}