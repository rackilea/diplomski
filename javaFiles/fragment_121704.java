int[] f = new int[n + 1];
f[0] = n;
for (int i = 1; i <= n; i++) {
    f[i] = in.nextInt();
}
System.out.println(Arrays.toString(f));