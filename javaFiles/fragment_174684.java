for (int row = 0; row < dataModel.getRowCount(); row++){
    for (int column = 0; column < dataModel.getColumnCount(); column++){
        data.add(dataModel.getValueAt(row, column).toString());
    }
    // Probably add new line to 'data'
}