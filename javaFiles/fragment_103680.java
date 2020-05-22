public static int getHighTemp(int[][] arr) 
{
    int high = -1;
    for(int i = 0; i<12;i++){
        if(high<arr[i][0])
            high = arr[i][0];
    }
    return high;
}

public static int getLowTemp(int[][] arr) 
{
    int low = 665456456;
    for(int i = 0; i<12;i++){
        if(low>arr[i][1])
            low = arr[i][1];
    }
    return low;

}