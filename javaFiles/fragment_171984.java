while (resultSet.next()) {

    data_rows = new Vector();

    for (int j = 1; j < columns; j++) {
        data_rows.addElement(resultSet.getString(j));

    }

    dtm.addRow(data_rows);
}