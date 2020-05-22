public static void main(String[] args) throws CloneNotSupportedException {
    Map<Double, List<Double>> myMap = create(1, 3);
}

public static Map<Double, List<Double>> create(double row, double column) {
    Map<Double, List<Double>> doubleMap = new HashMap<Double, List<Double>>();

    for (double x = 0; x < row; x++) {
        for (double y = 0; y < column; y++) {
            doubleMap.put(x, new ArrayList<Double>());
        }
    }
    return doubleMap;
}