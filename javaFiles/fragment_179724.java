public int getLabelIdByLabelName(String labelName) throws ApiException {
    return labelsAPI.listAllLabels().stream()
        .filter(label -> label.getName().equals(labelName))
        .findFirst()
        .map(Labels::getId)
        .orElse(0);
}