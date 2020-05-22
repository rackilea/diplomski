static int median(int[] arr, int low,int hig) 
{
    if ((low+hig)%2 == 0) return arr[(low+hig)/2];
    int mid=(low+hig)/2;
    return (arr[mid]+ arr[mid-1])/2;
}