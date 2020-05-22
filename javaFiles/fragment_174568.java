public static void main(String args[]) throws Exception {
    int[] a = new int[] { 2, 7, 2, 8 };
    int[] b = new int[] { 4, 6, 3, 9, 5, 8, 7};
    int[] max = maxArr(a, b);

    System.out.println(Arrays.stream(max).boxed().collect(Collectors.toList()));
}