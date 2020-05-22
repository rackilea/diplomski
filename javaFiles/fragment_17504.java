int binarySearch(int v, int l, int u) {
    if (l <= u) {
       find mid
       is the element at mid:
           return 1;// Can be 'mid' to return the index at which it was found.
       should we go left:
           return binarySearch(v, l, mid - 1);
       should we go right:
           return binarySearch(v, mid + 1, u);
    } 
    return -1; //Not found
}