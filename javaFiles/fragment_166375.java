int row;
....
// make sure row is set to index of the table row
// you want to populate
for (int c=0; c<values.length; ++c)
    detail.setValueAt(values[c], row, c);