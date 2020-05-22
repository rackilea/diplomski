private static double[] getDoubleArray(String strLine) {
    double[] a;
    String[] split = strLine.split("[,)]"); //split the line at the ',' and ')' characters
    a = new double[split.length-1];
    for(int i = 0; i < a.length; i++){
        a[i] = Double.parseDouble(split[i+1]); //get the double value of the String
    }
    return a;
}