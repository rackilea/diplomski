public static int binarySearch(int n[], int f, int l, int val) {
    if(f>l){
        return -1;
    } else {
        int mid = (f+l)/2;
        if(val == mid) {
            return n[mid];
        } else {
            if(val < mid) {
                return binarySearch(n, f, mid-1, val);
            } else {
                return binarySearch(n, mid+1, l, val);
            }
        }
    }
}