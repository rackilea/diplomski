TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
table.setRowSorter(sorter);
List<RowSorter.SortKey> sortKeys = new ArrayList<>();

int columnIndexToSort = 0; //This is the first column
sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

sorter.setSortKeys(sortKeys);
sorter.sort();