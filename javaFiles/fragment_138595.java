static void rearrangeEvenAndOdd(int arr[]) {
    int j, temp;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] % 2 == 0) {
            temp = arr[i];
            j=i-1;
            while(j>=0 && arr[j]%2==1) {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
    }
}