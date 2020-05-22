public int calculateTotalPrice() {
    int[] selections = otherPrdctList.getSelectedIndices();
    int total = 0;
    for (int i : selections) {
        total += miscellaneousProdPri[i];
    }
    return total;
}