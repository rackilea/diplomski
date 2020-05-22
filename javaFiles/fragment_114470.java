RowFilter basic = ..
 RowFilter other = ...
 RowFilter finer = Rowfilter.andFilter(basic, other);

 basicTable.getRowSorter().setRowFilter(basic);
 finerTable.getRowSorter().setRowFilter(finer);