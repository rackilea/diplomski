public static String getHtmlTable(List<Cell> cells) {

    // Sort the cells primarily on row, secondarily on column.
    Collections.sort(cells, new Comparator<Cell>() {
        public int compare(Cell c1, Cell c2) {
            int pri = Integer.valueOf(c1.row).compareTo(c2.row);
            int sec = Integer.valueOf(c1.col).compareTo(c2.col);
            return pri != 0 ? pri : sec;
        }
    });

    // Lay out the cells row by row.
    StringBuilder result = new StringBuilder("<table><tbody>");
    for (int row = 0, i = 0; i < cells.size(); row++) {
        result.append("<tr>\n");
        for (; i < cells.size() && cells.get(i).row == row; i++)
            result.append(cells.get(i).asTdTag());
        result.append("</tr>\n");
    }
    return result.append("</tbody></table>").toString();
}