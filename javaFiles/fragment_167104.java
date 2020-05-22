public static List<Integer> mode(int[] a) {
    List<Integer> lstMode = new ArrayList<Integer>();
    final int MAX_RANGE = 1001;
    int[] counterArray = new int[MAX_RANGE]; //can be improved with some maths :)!
    //setting the counts for the counter array.
    for (int x : a) {
        counterArray[x]++;
    }
    //finding the max value (mode).
    int maxCount = counterArray[0];
    for(int i = 0; i < MAX_RANGE; i++) {
        if (maxCount < counterArray[i]) {
            maxCount = counterArray[i];
        }
    }
    //getting all the max values
    for(int i = 0; i < MAX_RANGE; i++) {
        if (maxCount == counterArray[i]) {
            lstMode.add(new Integer(i));
        }
    }
    return lstMode;
}