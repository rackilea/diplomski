public static double calculateStandardDeviation(double[] sd) {

    double sum = 0;
    double newSum = 0; 

    for (int i = 0; i < sd.length; i++) {
        sum = sum + sd[i];
    }
    double mean = (sum) / (sd.length); 

    for (int j = 0; j < sd.length; j++) {
        // put the calculation right in there
        newSum = newSum + ((sd[j] - mean) * (sd[j] - mean)); 
    }
    double squaredDiffMean = (newSum) / (sd.length); 
    double standardDev = (Math.sqrt(squaredDiffMean)); 

    return standardDev; 
}