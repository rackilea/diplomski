String[] arr1 = {"A", "c", "c",  "", "", "c", "c", "B", "", "c","c", "", "A",  "", "", "B", "B", "A"};
int[] arr2 = {2, 3, 3, 0, 0, 2, 1, 3, 0, 2, 3, 0, 2, 0, 0, 3, 2, 3};

int len = arr1.length, sum=0;
int[] arr3 = new int[len];

for(int i=0; i<len; i++){
    arr3[i] = 0;
}

for(int i = 0 ; i < len ; i++ ){
    sum=0;
    if(arr1[i].equals("A") || arr1[i].equals("B")){
        sum += arr2[i];
        int j=0;
        for(j = i+1; j < len && !arr1[j].equals("A") && !arr1[j].equals("B"); j++){
            sum += arr2[j];
        }
        arr3[i] = sum;
        i= j-1 ;
    }
}