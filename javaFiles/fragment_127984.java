@Override
public Class<?> getColumnClass(int columnIndex) {
    switch (columnIndex) {
        case 0: return Integer.class; // Id column
        case 1: return String.class; // Name column
        case 2: return Date.class; // Date column
            default: return super.getColumnClass(columnIndex);
    }
}