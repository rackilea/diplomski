for (XWPFTable tbl : document.getTables()) {
            for (XWPFTableRow row : tbl.getRows()) {
                y++;
                for (XWPFTableCell cell : row.getTableCells()) {                
                   .
                   .
                   .
                   .

            if( add ) {
                XWPFTableRow row =tbl.createRow();

                 row.addNewTableCell().setText("some thing");

                tbl.addRow(row, y);

                break;}