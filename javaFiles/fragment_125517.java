/* It is a good programming practice to make the formal parameters `final` */
public double[] fiveNumberSummary(final double[] dataSet) {
    double[] newDataSet = new double[dataSet.length];
    /* Copy Array */
    System.arraycopy(dataSet, 0, newDataSet, 0, dataSet.length);
    ...
    /* Use newDataSet instead of dataSet */
    ...
    ...
}