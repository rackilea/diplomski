private List<double[][]> generateArrayListWithNElements(int n) {
    List<double[][]> arrayList = new ArrayList<>();

    for (int counter=0; counter<n; counter++) {        
        arrayList.add(new double[n][n]); 
    }

    return arrayList;
}