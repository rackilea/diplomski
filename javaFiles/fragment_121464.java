int rows=tmodel.getRowCount();
            while(rows>0)
            {
                tmodel.removeRow(0);
            }
            jTable1.setModel(tmodel);