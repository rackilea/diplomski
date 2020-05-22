public Class<?> getColumnClass(int columnIndex) {
  switch (columnIndex) {
    case 0: return Integer.class;
    case 1: return String.class;
    case 2: return Double.class;
    default: return null;
  }
}