int count=1;
for(int i=0; i<array.length-1;i++){
    if(array[i+1]!=array[i]){
        count++;
    }
}
Integer [] res = new Integer[count];
res[0] = array[0];
int resIndex = 1;
for(int i = 1; i < array.length - 1; i++){
    if(array[i] != array[i+1]) {
        res[resIndex] = array[i+1];
        resIndex++;
    }
}