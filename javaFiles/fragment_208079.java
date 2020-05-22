if (table.isCellSelected(row, column))
    setForeground(Color.red);
else if (table.isRowSelected(row))
    setForeground(Color.green);
else if (table.isColumnSelected(column))
    setForeground(Color.blue);
else
    setForeground(Color.black);