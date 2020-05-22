public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] f = new int[n];
    for (int i = 0; i < n; i++) {
        f[i] = in.nextInt();
    }
    System.out.println(Arrays.toString(f));
}