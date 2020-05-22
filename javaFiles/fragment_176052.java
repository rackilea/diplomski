// The actual implementation passes the starting index
private static int sum(int[] a, int start){
    if(a.length == start){
        return 0;
    }
    return sum(a, start+1) + a[start];
}
// Make sure the method can be called with an array argument alone
public static int sum(int[] a) {
    return sum(a, 0);
}