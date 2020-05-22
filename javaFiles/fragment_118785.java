try {
            comboBox.removeAllItems();

            sql = "SELECT * FROM `table_name`";
            rs = stmnt.executeQuery(sql);

        while (rs.next()) {
            String val = rs.getString("column_name");
            comboBox.addItem(val);
        }
    } catch (SQLException ex) {
        Logger.getLogger(DefineCustomer.class.getName()).log(Level.SEVERE, null, ex);
    }