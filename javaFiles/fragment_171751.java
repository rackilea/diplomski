String arr[] = { "A", "B", "C", "D" };
int n = arr.length;
int N = (int) Math.pow(2d, Double.valueOf(n));  
for (int i = 1; i < N; i++) {
    String code = Integer.toBinaryString(N | i).substring(1);
    for (int j = 0; j < n; j++) {
        if (code.charAt(j) == '1') {
            System.out.print(arr[j]);
        }
    }
    System.out.println();
}