Elements elementsFeatures = docProductsAttr.select("#featureTab"); // Feature
if (!elementsFeatures.isEmpty()) {
    for (Element row : elementsFeatures.select(".compare-products tbody tr")) {
        Elements rowCells = row.select("td");
        String gpsMap = rowCells.first().text();
        int i = 1;

        for (Element columnHeader : elementsFeatures.select(".compare-products thead tr th:gt(0)")) {
            System.out.format("%s -> %s: %s%n", columnHeader.text(), gpsMap, yesOrNo(rowCells.get(i)));
            i++;
        }
        System.out.println();
    }
}

private static String yesOrNo(Element rowCell) {
    String ret = "no";
    if (rowCell.hasClass("checked")) {
        ret = "yes";
    }
    return ret;
}