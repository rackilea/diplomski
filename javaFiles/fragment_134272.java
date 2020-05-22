//Returns the array index of the maximum integer
public static int max(int[] integers) {
    int max = Integer.MIN_VALUE;
    int retVal = -1;
    if (integers == null) return retVal;  //needs to handle this case too
    for (int i = 0; i < integers.length; i++) {
        max = Math.max(max, integers[i]);
        if (integers[i] == max) retVal = i;
    }
    return retVal;
}