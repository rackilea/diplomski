public static void main(String[] args) {
    int n = 46;
    int [] arr = new int[n+1];
    arr[0] = 1;
    arr[1] = 1;
    arr[2] = 2;
    arr[3] = 4;
    for(int i = 3; i < n; i++){
        arr[i]= arr[i-1]+arr[i-2]+arr[i-3];
    }
    System.out.println(arr[n]);
}