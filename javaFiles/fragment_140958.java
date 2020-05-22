private static String getValue(XSSFRichTextString cellContent){
    String value = "";
    for (int i = 0; i < cellContent.numFormattingRuns() - 1; i++) {
        int lenVal = cellContent.getLengthOfFormattingRun(i);
        int iVal = cellContent.getIndexOfFormattingRun(i);
        value += cellContent.toString().substring(iVal, lenVal + iVal);
    }
    return value;
}
private static String getSuperScript(XSSFRichTextString cellContent) {
    int lenSuper = cellContent.getLengthOfFormattingRun(cellContent.numFormattingRuns() - 1);
    int iSuper = cellContent.getIndexOfFormattingRun(cellContent.numFormattingRuns() - 1);
    return cellContent.toString().substring(iSuper, lenSuper + iSuper);
}