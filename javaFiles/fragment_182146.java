// TableModelListener
@Override
public void tableChanged(TableModelEvent e) {
    updateRowHeights();
}

// TableColumnModelListener
@Override
public void columnMarginChanged(ChangeEvent e) {
    updateRowHeights();
}