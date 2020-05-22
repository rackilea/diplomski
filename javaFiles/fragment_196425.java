public static double[][] PDF_CDF_SF(int Sojourn_Time[], double Shape_Factor[], int Num_Analysis_Years) {
    double[] CDF = new double[Num_Analysis_Years];
    double[] PDF = new double[Num_Analysis_Years];
    double[] SF = new double[Num_Analysis_Years];
    for (int i = 0; i < Num_Analysis_Years; i++) {
        CDF[i] = 1;
        SF[i] = 1 - CDF[i];
        PDF[i] = 1;
    }
    double[][] ret = {CDF, PDF, SF};
    return ret;
}