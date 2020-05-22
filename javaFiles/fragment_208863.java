/** Computes the RMS volume of a group of signal sizes ranging from -1 to 1. */
public double volumeRMS(double[] raw) {
    double sum = 0d;
    if (raw.length==0) {
        return sum;
    } else {
        for (int ii=0; ii<raw.length; ii++) {
            sum += raw[ii];
        }
    }
    double average = sum/raw.length;

    double sumMeanSquare = 0d;
    for (int ii=0; ii<raw.length; ii++) {
        sumMeanSquare += Math.pow(raw[ii]-average,2d);
    }
    double averageMeanSquare = sumMeanSquare/raw.length;
    double rootMeanSquare = Math.sqrt(averageMeanSquare);

    return rootMeanSquare;
}