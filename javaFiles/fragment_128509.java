final int n = 3;
for (int i = 0; i < Math.pow(2, n); i++) {
    String bin = Integer.toBinaryString(i);
    while (bin.length() < n)
        bin = "0" + bin;
    System.out.println(bin);
}