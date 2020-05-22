public static int closestValue(int [] x , int max, int min) {
    int mid  = (max - min)/2;
    int m = x[0];
    int dif = 0, currentDif = 0;
    for (int i = 1; i < x.length; i++)
    {
        dif = mid - x[i];
        currentDif = mid - m;
        if (dif * dif < currentDif *currentDif)
            m = x[i];
    }
    return m;
}