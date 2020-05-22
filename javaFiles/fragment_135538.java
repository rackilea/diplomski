int start = 0;
    char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f'};
    int end = arr.length - 1;
    while (start <= end) {
        if (start == end) {
            System.out.print(arr[start]);
        } else {
            System.out.print(arr[start] + " " + arr[end] + " ");
        }
        start++;
        end--;
    }