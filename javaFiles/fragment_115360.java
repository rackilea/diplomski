public void merg(Integer[] arr,int l,int h){
    Integer[] tarr = new Integer[h-l+1];
    for(int p=0;p<tarr.length;p++) // corrected the range of the loop
        tarr[p]=0;
    int m=(h+l)/2; // the same fix of m calculation as before
    ...