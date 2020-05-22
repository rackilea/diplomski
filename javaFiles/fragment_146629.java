public static int sum(int[][]array){
int sum1 = 0;
for (int[] arr : array)
    for(int i: arr)
        sum1+=i;

return sum1;
}