public static void findHottest(int[] temp){
    int hottest = temp[0];
    int highestIndex = 0;

    for(int i = 1; i < temp.length; i++){
        if(temp[i] > hottest) {
            hottest = temp[i];
            highestIndex = i;
    }
}