public void sortDescending(Cities arr[], int n){
    String temp[]; //stores sorted array
    temp = new String[n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n-1;j++){//change this code as its checking array for j and j+1. so if you run you loop till n it will check array for n+1 hence array index out of bound error
        int len1 = arr[j].name.length();
        int len2 = arr[j+1].name.length();
        if(len1 < len2 ){
            temp[j] =  arr[j+1].name;
            temp[j+1] = arr[j].name;
        }
    }
 }