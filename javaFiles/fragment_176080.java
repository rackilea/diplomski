int[] count = new int[r + 1];
for (int i = 0; i < arr.length; i++) {
    if( arr[i] <= r) {
        count[arr[i]]++;
    }
}