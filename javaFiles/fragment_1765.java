static void minimumBribes(int[] q) {
    int []res=new int[q.length];
    boolean change=true;
    for(int i=0;i<q.length;i++)
        res[i]=0;
    while(change){
        change=false;
        for(int i=0,j=i+1;j<q.length;i++,j++){
            if(q[i]>q[j]){
                res[q[i]-1]++;
                arrSwap(q,i,j);
                change=true;
            }
        }
    }
    int n=0;
    for(int i=0;i<q.length;i++){
        if(res[i]>2){
            System.out.println("Too chaotic");
            return;
        }
        else
            n+=res[i];
    }
    System.out.println(n);
}

public static void arrSwap (int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}