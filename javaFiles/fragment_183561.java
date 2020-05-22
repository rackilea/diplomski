@Override
public Class<?> getColumnClass(int columnIndex) {
    switch (columnIndex) {
        case 0: {
            return String.class;
        }
        case 1: {
            return Integer.class;
        }
        case 2: {
            return Double.class;
        }
        case 3: {
            return Double.class;
        }
        default: {
            return Object.class;
        }
    }
}