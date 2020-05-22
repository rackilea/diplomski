public static void moveNulls(Object[] arr, int howMany) {
    int offset = arr.length;
    int nullCount = 0;
    while(nullCount < howMany) {
        if(arr[--offset] == null)
            nullCount++;
        if(offset == 0 && nullCount < howMany)
            throw new IllegalStateException("Not enough nulls");
    }
    int target = offset;
    while(offset < arr.length) {
        if(arr[offset] != null)
            arr[target++]=arr[offset++];
        else
            offset++;
    }
    Arrays.fill(arr, target, offset, null);
}