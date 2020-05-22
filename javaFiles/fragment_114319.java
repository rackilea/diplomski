class Renderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isFilterUsed() && isCellMatched(row, column)) {
            String stringValue = value.toString();
            String filter = getFilterValue();
            int start = stringValue.indexOf(filter);
            int end = start + filter.length();
            String result = String.format("<html>%s<font color='red'>%s</font>%s</html>",
                    stringValue.substring(0, start),
                    stringValue.substring(start, end),
                    stringValue.substring(end));

            return super.getTableCellRendererComponent(table, result, isSelected, hasFocus, row, column);
        } else {
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
}