public static void main(String[] args) throws Exception {
    int[] i1 = new int[]{1,2,3};
    int[] i2 = new int[]{1,2,3};
    int count = countArrays(i1, i2);
    System.out.println(count);
}

public static int countArrays(int[]... a) {
    return a.length;
}