public class SearchTermTableModel extends AbstractTableModel {

    private List<SearchTerm> searchTerms;

    public SearchTermTableModel() {
        searchTerms = new ArrayList<>(25);
    }

    public void add(SearchTerm searchTerm) {
        searchTerms.add(searchTerm);
        fireTableRowsInserted(searchTerms.size() - 1, searchTerms.size() - 1);
    }

    @Override
    public int getRowCount() {
        return searchTerms.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        return column == 0 ? "" : "Search Term";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnIndex == 0 ? Boolean.class : String.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SearchTerm term = searchTerms.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = term.isSelected();
                break;
            case 1:
                value = term.getText();
                break;
        }
        return value;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 0;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                if (aValue instanceof Boolean) {
                    SearchTerm term = searchTerms.get(rowIndex);
                    term.setSelected((Boolean)aValue);
                    super.setValueAt(aValue, rowIndex, columnIndex);
                }
                break;
        }
    }
}