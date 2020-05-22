for (int row = 0; row < peopleModel.getRowCount(); row++) {
    StringJoiner stringJoiner = new StringJoiner("/");
    for (int col = 0; col < peopleModel.getColumnCount(); col++) {
        stringJoiner.add(peopleModel.getValueAt(row, col).toString());
    }
    o.println(stringJoiner.toString());
}