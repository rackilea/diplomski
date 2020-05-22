public static double[] toDoubleArray(byte[] byteArray){
    double[] doubles = new double[byteArray.length];
    for(int i=0;i<doubles.length;i++){
        doubles[i] = byteArray[i]/128.0;
    }
    return doubles;
}