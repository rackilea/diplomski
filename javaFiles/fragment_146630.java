public static int[] sum(int[][]array){
int sum = 0;
int sumOfRow[] = new int[array.length];
for(int i=0;i<array.length;i++){
    sum=0;
    for(int num: array[i]){
        sum1+=num;
    }
    sumOfRow[i] = sum;
}

return sumOfRow;
}