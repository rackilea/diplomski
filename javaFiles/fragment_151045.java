public static double[] createArray (int n, Scanner enter){
    double[] tempArray = new double[n];
    int pos=0;
    while (enter.hasNext()) {
        tempArray[pos++] = enter.nextDouble();
        if (pos>=n)
            break;
    }
    return tempArray;
}