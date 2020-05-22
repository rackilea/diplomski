public static void deviation(double[] scores, double[] variance)
{
    double sum = 0;
    for (int i = 0; i < scores.length; i++){ 
        sum = sum + scores[i];
    }
    double average = sum / scores.length;

    for (int i = 0; i < scores.length; i++){ 
        variance[i] = scores[i] - average;
    }
}