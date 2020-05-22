public double[] getInterpolatedCoordinates(double julian){ //julian calendar? This variable name needs to be something else, like day, or time, or whatever it actually means
    int startIndex=(int)julian;
    int endIndex=(startIndex+1>=coordinates.length?1:startIndex+1); //wrap around

    double nonIntegerPortion=julian-startIndex;


    double[] start = coordinates[startIndex];
    double[] end = coordinates[endIndex];

    double[] returnPosition= new double[3];

    for(int i=0;i< start.length;i++){
        returnPosition[i]=start[i]*(1-nonIntegerPortion)+end[i]*nonIntegerPortion;
    }
    return returnPosition;
}