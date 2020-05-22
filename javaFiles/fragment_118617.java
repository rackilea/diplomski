public class TableBuilder {
    List<String[]> rows = new LinkedList<String[]>();

    public void sortByColumn(final int colIndex) {
        int maxIdx = 0;
        for (String[] s : rows) maxIdx = Math.max(maxIdx, s.length - 1);
        if (colIndex < 0 || colIndex >= maxIdx) {
            Collections.sort(rows, new Comparator<String[]>() {
                @Override
                public int compare(String[] strings, String[] otherStrings) {
                    return strings[colIndex].compareTo(otherStrings[colIndex]);
                }
            });
        }
    }
}