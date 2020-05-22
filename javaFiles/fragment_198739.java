public static int[] goLeft(int[] a) {
    int[] arr = a.clone();
    for (int j = 0, i = 0; j < arr.length; j++) {
        if (arr[j] != 0) {
            arr[i] = arr[j];
            if (i++ != j) arr[j] = 0;
        }
    }
    return arr;
}

public static int[] combine(int[] a) {
    int[] arr = a.clone();
    for (int j = 1, i = 0; j < arr.length; j++) {
        if (arr[i] == 0 && arr[j] != 0) {
            i = j;
        } else if (arr[j] != 0 && i != j) {
            if (arr[j] == arr[i]) {
                arr[i] *= 2;
                arr[j] = 0;
                i = j;
            } else {
                i = j;
            }
        }
    }
    return arr;
}

public static void main(String[] args) {
    int[] a1 = new int[] {4,2,0,2,4};
    System.out.println(Arrays.toString(a1));
    System.out.println(Arrays.toString(Main.goLeft(Main.combine(a1))));
    // [4, 4, 4, 0, 0]
}