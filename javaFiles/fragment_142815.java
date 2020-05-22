public static int belowaverage(double[] ba) {
    double sum = 0;
    double average = 0;
    int count = 0;

    for(int i = 0; i < ba.length; i++) {
        sum = sum + ba[i];
    }
    average = sum / ba.length;

    for(int i = 0; i < ba.length; i++){
        if (ba[i] < average) {
            count++;
        }
    }
    return count;
}