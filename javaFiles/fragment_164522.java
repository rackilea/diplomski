int[] a = { 1, 2, 3 };
int[] b = { 5, 6, 7 };

int[] sum = Arrays.copyOf(a, a.length + b.length);
System.out.println(Arrays.toString(sum));
// [1, 2, 3, 0, 0, 0]

System.arraycopy(b, 0, sum, a.length, b.length);
System.out.println(Arrays.toString(sum));
// [1, 2, 3, 5, 6, 7]