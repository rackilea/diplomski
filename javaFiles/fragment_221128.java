public static double calculateMean(double[] m){
    if (m.length == 0) return 0; // don't divide by zero!

    // ... the rest of your stuff
}

public static double calculateStandardDeviation(double[] sd){

    if (sd.length == 0) return 0; // don't divide by zero!

    double sum = 0;

    double mean = calculateMean(sd);

    for (int i = 0; i<sd.length; i++){
        sum = sum + (sd[i] - mean) * (sd[i] - mean);
    }
    double squaredDiffMean = (sum) / (sd.length); 
    double standardDev = (Math.sqrt(squaredDiffMean)); 

    return standardDev; 
}