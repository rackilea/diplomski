try {
        ResultSetMetaData rm = rs.getMetaData();
        int j = rm.getColumnCount();
        JTable table=new JTable();
        int rowCount = table.getRowCount();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Vector v = null;
        if (rowCount == 0) {
            while (rs.next()) {
                v = new Vector();

                for (int i = 1; i <= j; i++) {
                    String type = rm.getColumnTypeName(i);
                    // System.out.println(type);
                    switch (type) {
                        case "FLOAT":
                            v.add(rs.getFloat(i));
                            break;
                        case "COUNTER":
                            v.add(rs.getInt(i));
                            break;
                        case "VARCHAR":
                            v.add(rs.getString(i));
                            break;
                        case "INTEGER":
                            v.add(rs.getInt(i));
                            break;
                        case "DATETIME":
                            v.add(rs.getString(i));
                            break;
                        case "MEDIUMINT":
                            v.add(rs.getInt(i));
                            break;
                        case "LONGBLOB":
                            v.add(rs.getTime(i));
                            break;
                        default:
                            v.add(rs.getString(i));
                    }
                }
                model.addRow(v);
            }