int[] a = {0, 10, 0, 0};
int i = 0;
a[i++] = a[i++] + 2;

System.out.println(Arrays.toString(a)); // [12, 10, 0, 0]
System.out.println(i);                  // 2