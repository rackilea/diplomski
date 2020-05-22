public void tableChanged(TableModelEvent event) {
    if (event.getColumn() == COLUMN_TO_IGNORE) {
        return;
    } else {
        maths();
    }
}