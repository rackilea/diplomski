public static double[] addition(double[] one,double[] two){
    double[] resultset = new double[one.length];  //creat new array for the results
    for(int i = 0; i<one.length; i++)             //iterate over the arrays to calculate the results
        resultset[i] = one[i] + two[i];           //calculate the result
    return resultset;                             //return resultset array
}