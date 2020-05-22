if(A[mid] == x) {
    result = mid;   
    int maybeResultToLeft = firstOccur(A, x, first, mid-1);
    if (maybeResultToLeft == -1) {
       return result;
    }
    return maybeResultToLeft;
}