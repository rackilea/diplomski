TableRowSorter sorter = (TableRowSorter) table.getRowSorter();
List <RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
sortKeys.add(new RowSorter.SortKey(table.getColumnModel().getColumnIndex("aColumnID"), SortOrder.ASCENDING));
sortKeys.add(new RowSorter.SortKey(table.getColumnModel().getColumnIndex("bColumnID"), SortOrder.UNSORTED));
 // to specify no sorting should happen on 'bColumnID'
sorter.setSortKeys(sortKeys);