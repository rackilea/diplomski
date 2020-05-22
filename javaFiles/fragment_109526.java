public static void main(String[] args) {
    int[] arr = {6,1,3,5,2};
    int position = 5;
    int times = arr[position - 1];
    int count = 0;
    for(int i = 0; i < (times * arr.length); i++){
        if(arr[i % arr.length] != 0){
            arr[i % arr.length] = arr[i % arr.length] - 1;
            count++;
        }
    }
    System.out.println("Count: " + count);
}