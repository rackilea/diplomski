/**
 * Convert an Excel-style column index to an Excel-style column name.
 * @param colIndex first index = 1, per Excel standard
 * @return Excel-style column name
 */
public String toExcelHeaderName(int colIndex) {
    StringBuilder sb = new StringBuilder();
    int div = colIndex;
    do {
        div = div - 1;
        int remainder = div % 26;
        char colLetter = (char) ('A' + remainder);
        sb.insert(0, colLetter);
        div = (div / 26);
    } while (div > 0);
    return sb.toString();
}