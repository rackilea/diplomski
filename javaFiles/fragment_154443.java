public static int countmaxDuplicate(int arr[]) {
    int maxcount = 0;

    for (int i = 0; i < arr.length - 1; i++) {
        int count = 1;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] == arr[j]) {
                count++;
            }

        }
        maxcount = Integer.max(maxcount, count);
    }

    return maxcount;
}