public double MyMin(double... myArray) {
    double minValue = Double.MAX_VALUE; // start with largest possible value
    // loop through and replace with any smaller values
    for (double val : myArray)
        if (val < minValue) minValue = val;
    // val now contains the smallest value
    return val;
}