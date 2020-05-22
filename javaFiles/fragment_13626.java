Vector v = new Vector();
        while (resultSet.next()){
            String list = resultSet.getString("itemname");
            v.add(list);

        }
        conn.close();
        purcItemName.setModel(new DefaultComboBoxModel(v));