private  static void countSwaps(int[] a, int size) {
    int temp,count=0;
    for(int i=0;i<size;i++){
        for(int j=0;j<size-1;j++){
            if(a[j]>a[j+1]){
                temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
                ++count;
            }
        }
    }
    System.out.println("Array is sorted in"+count+"swaps.");
    System.out.println("First Element:"+a[0]);
    System.out.println("Last Element:"+a[a.length-1]);

}