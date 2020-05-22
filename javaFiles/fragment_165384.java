for (int i = arr.length; i > 0; i--) {
    for (int j = 0; j < i - 1; j++) {
        int x = arr[j].compareTo(arr[j + 1]);
        if (x > 0) {
            tmp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = tmp;
        }

    }
}