public static int [] removeOdd(int[] input){

    int c = 0;
    for(int i=0; i<input.length; i++){
        if(input[i]%2==0){
            c++;
        }
    }
    int [] a = new int[c];
    int k = 0;
    for(int i=0; i<input.length; i++){
        if(input[i]%2==0){
            a[k] = input[i];
            k++;
        }
    }
    return a;
}