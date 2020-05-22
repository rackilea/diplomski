class WCCTableRowData {
    Comparable<?> getField(String name) { ... }
}

String name = "C";
searchResults.sort(Comparator.comparing(row -> row.getField(name)));