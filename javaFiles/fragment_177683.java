public String toCsvRow() {
    String csvRow = "";
    for (String value : Arrays.asList(page, document, loan, type)) {
        String processed = value;
        if (value.contains("\"") || value.contains(",")) {
            processed = "\"" + value.replaceAll("\"", "\"\"") + "\"";
        }
        csvRow += "," + processed;
    }
    return csvRow.substring(1);
}