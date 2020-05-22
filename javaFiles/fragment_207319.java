while (rs.next()) {
            Object[] row = new Object[columns];
            for (int i = 1; i <= columns; i++) {
                row[i-1] = rs.getObject(i);
            }

                Object sub = row[0];
                Object ses = row[1];
                Object as1 = row[2];
                Object as2 = row[3];
                Object as3 = row[4];
                Object fe = row[5];
                Object id = row[6];                   

                Object[] row2 = new Object[columns];
                row2[0] = id;
                row2[1] = sub;
                row2[2] = ses;
                row2[3] = as1;
                row2[4] = as2;
                row2[5] = as3; 
                row2[6] = fe;

            ((DefaultTableModel) table.getModel()).insertRow(rs.getRow() - 1, row2);
        }