public static void mergesort(int x[],int low,int high, int a[]){      
    if (low>high) {
        return;
    }
    int middle=(low+high)/2;
    mergesort(x,low,middle,a);
    mergesort(x,middle+1,high,a);