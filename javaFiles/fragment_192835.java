Map<String, Function<WCCTableRowData, Comparable<?>>> getters = new HashMap<>();
getters.put("A", WCCTableRowData::getA);
getters.put("B", WCCTableRowData::getB);
getters.put("C", WCCTableRowData::getC);

String name = "C";
searchResults.sort(Comparator.comparing(getters.get(name)));