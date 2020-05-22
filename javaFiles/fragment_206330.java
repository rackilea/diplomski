private static double[] process(double[] enterArray) {
    int range = enterArray.length;
    System.out.println("Array Length: " + enterArray.length);
    for (int x = 0; x < enterArray.length; x++) {
        int j = findMax(range, enterArray);
        swap(j, range-1, enterArray);
        range--;
    }
    return enterArray;
}