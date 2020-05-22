public static void main(String[] args) {
    int[] arr = new int[10];
    int max = arr[0];
    int min = arr[0];
    FullArr(arr);
    MinArr(arr);
    for (int i = 0; i < arr.length; i++) {
        if (max < arr[i]) {
            max = arr[i];
        }
        System.out.println();
        System.out.println(max);
    }
}

public static void FullArr(int[] ar) {
    int[] arr = new int[ar.length];
    for (int i = 0; i < arr.length; i++) {
        ar[i] = (int) (Math.random() * 100);
        System.out.print(ar[i] + ", ");
    }
}

public static void MinArr(int[] ar) {
    int min = ar[0];
    for (int i = 0; i < ar.length; i++) {
        if (min > ar[i]) {
            min = ar[i];
        }
    }
    System.out.println();
    System.out.println(min);
}