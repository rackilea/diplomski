public static void downHeap(int location){
if(location < sizeOfTree){
    int p = location;
    int l = 2*p;
    int r = 2*p+1;
    int s = sizeOfTree;
    if(r<s && heap[r]<heap[p] && heap[r]<heap[l]){
        int temp = heap[r];
        heap[r] = heap[p];
        heap[p] = temp;
        downHeap(r);
    }else if(l<s && heap[l]<heap[p]){
        int temp = heap[l];
        heap[l] = heap[p];
        heap[p] = temp;
        downHeap(l);
    }
}}