private String[][] data = {
    {"Name:", "Mr Nick Woodward"},
    {"City:", "Reading"},
    {"Long:", "Supercalafragalisticexpyaladocious"},
};

private String getTable() {
    StringBuilder sb = new StringBuilder("<html><table>");

    for (String[] row : data) {
        sb.append("<tr>");
        sb.append("<td>");
        sb.append(row[0]);
        sb.append("</td>");
        sb.append("<td style='text-align: right;'>");
        sb.append(row[1]);
        sb.append("</td>");
        sb.append("</tr>");
    }

    return sb.toString();
}