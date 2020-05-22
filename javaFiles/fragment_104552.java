int n = arr.length;
    int middle = n / 2;
    int[] output = new int[n];

    for (int i = 0; i < middle; i++){
        output[2 * i] = arr[i];
        output[2 * i + 1] = arr[i + middle];
    }