public double[] getInterpolatedCoordinates(double julian, double[] store){
    int startIndex=(int)julian;
    int endIndex=(startIndex+1>=coordinates.length?1:startIndex+1); //wrap around

    double nonIntegerPortion=julian-startIndex;


    double[] start = coordinates[startIndex];
    double[] end = coordinates[endIndex];

    double[] returnPosition= store;

    for(int i=0;i< start.length;i++){
        returnPosition[i]=start[i]*(1-nonIntegerPortion)+end[i]*nonIntegerPortion;
    }
    return returnPosition; //store is returned
}