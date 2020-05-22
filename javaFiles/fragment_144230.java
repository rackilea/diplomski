List<Model> get10(List<Model> numList, int i) {
    if (i >= numList.size()) {
        return new ArrayList<>();
    }
    int i2 = Math.min(i + 10, numList.size());
    return new ArrayList(numList.subList(i, i2));
}