public void someMethod(int[] arr){
    for(int i=arr.length-1; i >= 0; i--){
        if(arr[i] <= 8){
           arr[i]+=1;
        }else if(arr[i] ==9){
         arr[i] = 0;
    }
    }
}