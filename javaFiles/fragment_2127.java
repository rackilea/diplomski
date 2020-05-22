private static int[] exchange(int[] a) {
    int[] someArray = new int[a.length];
    int count = 0;
    for (int num : a) {
        if (num != 0) {
            someArray[count] = num;
            count++;
        }
    }
    return someArray;
}

int[] a = new int[] { 5, 4, 0, 3, 2, 0, 1, 7, 0 };
System.out.println(Arrays.toString(exchange(a)));