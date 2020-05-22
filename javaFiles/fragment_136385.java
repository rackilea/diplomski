public static void dualSelectionSort(int[]a) {
    for(int i=0; i<a.length-1;i++) {
        int min=i;
        int max=(a.length-1)-i;

        for (int j=i;j<a.length-i;j++) {
            if(a[j]<a[min]) {
                min=j;
            }
            if(a[j]>a[max]) {
                max=j;
            }
        }
        if(i==max) {
            swap(a,max,a.length-1-i);
            swap(a,min,i);
        }else {
            swap(a,min,i);
            swap(a,max,(a.length-1)-i);
        }       
    }
}

public static void swap(int[] a,int i,int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}