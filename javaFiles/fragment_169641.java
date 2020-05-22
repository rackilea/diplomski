public static int findResult(int[] arr, int len) {
    if(len == 0) return -1;
    if(len == 1) return arr[0];

    int element = arr[0];
    int count = 1;
    for(int i = 1; i < len; i++) {
        if(arr[i] == element) {
            count++;
        } else if(count > 0) {
            count--;
        } else {
            element = arr[i];
            count = 1;
        }
    }

    count = 0;
    for(int a:arr) {
        if(a == element) {
            count++;
        }
    }

    return (count > len / 2) ? element : -1;
}