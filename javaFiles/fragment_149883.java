for (int i = 0; i < rows.length; i++) {
    for (int j = 0; j < columns.length; j++) {
            data = (String) jt.getValueAt(rows[i], columns[j]);
            System.out.println("Table element selected is " + data);
    }
}