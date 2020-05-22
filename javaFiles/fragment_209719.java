int[] test = { 1, 2, 3, 4, 5, 6 };
int l = test.length;
do {
    l = sumTo(test, l);
} while (l > 1);
System.out.println(Arrays.toString(test));