@Override
public Class<?> getColumnClass(int columnIndex) {
    switch (columnIndex) {
        case 0:
            return String.class;
        case 1:
            return String.class;
        case 2:
            return String.class;
        case 3:
            return Integer.class;
        case 4:
            return Integer.class;
        case 5:
            return Integer.class;
        case 6:
            return Person.class;

    }
    return Object.class;
}