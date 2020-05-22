private static LinearFunction[] aproxFunction(List<Point> list) {
try{
    int amountOfClusters = getAmountOfClusters(list);
    //System.out.println(amountOfClusters); for debug
    LinearFunction[] linear = new LinearFunction[amountOfClusters];
    int[][] clusters = new int[amountOfClusters][2]; // 2nd field 0 == r, 1 == g, 2 == b
    clusters = getClusters(list, amountOfClusters);
    for(int i = 0; i < amountOfClusters; i++) {
        linear[i] = new LinearFunction()
        ...