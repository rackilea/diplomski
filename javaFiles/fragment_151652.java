// List<List<String[]>> myBigList = new ArrayList<List<String[]>>();
String[][][] amyBigArray = new String[myBigList.size()][][];
for (int i = 0; i < myBigList.size(); i++) {
    int innerSize = myBigList.get(i).size();
    String[][] innerArray = new String[innerSize][];
    for (int j = 0; j < innerSize; j++) {
        innerArray[j] = myBigList.get(i).get(j);
    }
    amyBigArray[i] = innerArray;
}