int[] countArray= new int[array.length];
for(int i = 0; i < array.length; i++) {
    int count=0;
    for(int j = i + 1; j < array.length-1; j++) {
        if(array[i] > array[j]) {
            count++;
        }
    }
    countArray[i]=count;
}