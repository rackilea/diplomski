public void swap(int src, int dest, int[] a) {
    if(src <= dest)      // reverse src and dest
    {
        int temp = a[dest];
        a[dest] = a[src];
        a[src] = temp;

        dest++; // no use, dest is local
        src++; // idem
    }
}