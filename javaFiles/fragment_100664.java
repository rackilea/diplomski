public static int getLowestDouble(double[] numArray){
    double lowest = numArray[0];
    for (double check : numArray)
        if (check < lowest)
           lowest = check;
    return (int) lowest; 
}