int binarySearch(int v) {
    if (l <= u) {
       find mid
       is the element at mid:
           return 1;// Can be 'mid' to return the index at which it was found.
       should we go left:
           u = mid - 1
           return binarySearch(v);
       should we go right: 
           l = mid + 1
           return binarySearch(v);
    } 
    return -1; //Not found
}