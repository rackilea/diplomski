public static double[][] to2DArray(List<List<Double>> input) {
    double[][] output = new double[input.size()][];
    for (int i = 0; i < input.size(); i++) {
        output[i] = new double[input.get(i).size()];
        for (int j = 0; j < input.get(i).size(); j++) {
            output[i][j] = input.get(i).get(j);
        }
    }
    return output;
}