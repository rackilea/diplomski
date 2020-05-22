public List<DetailCostProxy> getCostList() {
    ...

    try {
        DetailCostProxy cost = lineCount.getCostDetail()
        costDetails.add(cost);
    catch (NumberFormatException e) {
        costDetails.add(null);
    }

    ...
}