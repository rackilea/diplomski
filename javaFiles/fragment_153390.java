public static boolean checkSum(int[] arr) {
    HashSet<Integer> set = new HashSet<Integer>();
    for (int n : arr) {
        set.add(n);
    }

    for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (set.contains(arr[i] + arr[j])) return true;
        }
    }
    return false;
}