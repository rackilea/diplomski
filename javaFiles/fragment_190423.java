public static void main(String[] args) {
    System.out.println(printPairs(new int[]{3, 3, 3, 3}, 6)); // 6
    System.out.println(printPairs(new int[]{4, 4, 1}, 5)); // 2
    System.out.println(printPairs(new int[]{1, 2, 3, 4, 5, 6}, 7)); // 3
    System.out.println(printPairs(new int[]{3, 3, 3, 3, 1, 1, 5, 5}, 6)); // 10
}

public static int printPairs(int arr[], int sum) {
    int count = 0;
    int[] quantity = new int[sum];
    for (int i = 0; i < arr.length; ++i) {
        int supplement = sum - arr[i];
        if (supplement >= 0) {
            count += quantity[supplement];
        }
        quantity[arr[i]]++; // You may need to check that arr[i] is in bounds
    }
    return count;
}