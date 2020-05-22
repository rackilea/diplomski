@Override
public Class<?> getColumnClass(int columnIndex) {
    if (isDate(columnIndex)) {
        return Date.class;
    }
    else {
        return String.class;
    }
}