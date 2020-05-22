for (int j = i; j < arr.length; j++) {
        maxAt = arr[j] > arr[maxAt] ? j : maxAt;
    }
    max = arr[maxAt];
    if (arr[i] < max) {
        arr[maxAt] = arr[i];
        arr[i] = max;
    }