public void merg(Integer[] arr,int l,int h) {
    Integer[] tarr = new Integer[h-l+1];
    for(int p=0;p<=h;p++)
        tarr[p]=0;
    int m=(h-l)/2;
    ...