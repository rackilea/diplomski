public static int distNum(int[] number, int[] counter, int numcounter) {
    for (int i = 0; i < number.length; i++) {
        boolean isUnique = true;
        for (int j = 0; j < numcounter; j++) {
            if (counter[j] == number[i]) {
                isUnique = false;
                break;
            }
        }
        if (isUnique) {
            counter[numcounter] = number[i];
            numcounter++;
        }
    }
    return numcounter;
}