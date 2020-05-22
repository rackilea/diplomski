static <T> void swap(T[] a, int i, int j) {
    T t = a[i];
    a[i] = a[j];
    a[j] = t;
}

static void permutation(int[][] perm, int n, List<int[][]> result) {
    int size = perm.length;
    if (n >= size)
        result.add(Arrays.copyOf(perm, size));
    else
        for (int i = n; i < size; i++ ) {
            swap(perm, n, i);
            permutation(perm, n + 1, result);
            swap(perm, n, i);
        }
}
public static int[][][] permutation(int[][] perm) {
    List<int[][]> result = new ArrayList<>();
    permutation(perm, 0, result);
    return result.toArray(new int[0][][]);
}

public static void main(String[] args) {
    int[][] gridInterFT={{1,2},{2,3},{3,4},{1,3},{1,4},{2,4}};
    int[][][] r = permutation(gridInterFT);
    for (int[][] a : r) {
        for (int i = 0; i < a.length; ++i)
            System.out.print(Arrays.toString(a[i]));
        System.out.println();
    }
}