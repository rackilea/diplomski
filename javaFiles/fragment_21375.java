public static void evenOdd(int[] arr){
    int i=0;
    int count = 0;
    int arr1[] = new int[5];
    for (i=0;i<5;i++) { 
        if (arr[i]%2==0) {
            arr1[count]=arr[i];
            count++;
        }
    }
    for (i=0;i<5;i++){
        if(arr[i]%2!=0) {
            arr1[count]=arr[i];
            count++;
        }
    }//end for
    for(i=0; i < 5; i++) {
        System.out.print(arr1[i]+"\n");
    }
}//end method