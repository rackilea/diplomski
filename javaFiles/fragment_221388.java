int[] arr = {5,10,23,6,9};
int max = 23; //you should do this dynamically in the general case
while(max > 0) {
    for(int i = 0; i < arr.length; i++) {
        if(arr[i] >= max) {
            System.out.print("*");
        } else {
            System.out.print(" ");
        }
    }
    System.out.println();
    max--;
}