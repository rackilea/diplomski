public static boolean isWay(int[] a,int i) {
    int temp1 , temp2;
    if(i == a.length-1) {
        return true;
    }
    boolean found = false;
    if(a[i]+i < a.length && a[a[i]+i] > 0) { // go right
        temp1 = a[i] + i;
        a[i] = -1;
        found = isWay(a, temp1);
        if (!found) {
            a[i] = temp1 - i; // must restore a[i] to its original value, in order 
                              // to be able to go left
        }
    }
    if (!found && i-a[i] >= 0 && a[i - a[i]] > 0) { // go left
        temp2 = i - a[i];
        a[i] = -1;
        found = isWay(a, temp2);   
    }
    return found;
}