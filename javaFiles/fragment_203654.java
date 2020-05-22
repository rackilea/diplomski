final JTable table = (JTable) jComp.get(a);
tbl.getTableHeader().setReorderingAllowed(false); 

 Action actionProd = new AbstractAction() {

    public void actionPerformed(ActionEvent e) {

        Utility util = new Utility("GoldNew");

        TableCellListener tcl = (TableCellListener) e.getSource();
        System.out.println("Row   : " + tcl.getRow());
        System.out.println("Column: " + tcl.getColumn());
        System.out.println("Old   : " + tcl.getOldValue());
        System.out.println("New   : " + tcl.getNewValue());
        int colNo = ((table.getModel().getColumnName(tcl.getColumn()).equalsIgnoreCase("Qty"))
                || (table.getModel().getColumnName(tcl.getColumn()).equalsIgnoreCase("Weight"))
                || (table.getModel().getColumnName(tcl.getColumn()).equalsIgnoreCase("Wt"))
                ? tcl.getColumn() : -1);

        if (tcl.getColumn() == colNo) {
            int wt = 0;
            Object qtyO = tcl.getNewValue();
            try {
                qtyO = tcl.getNewValue();
                if (qtyO != null) {
                    wt = Integer.parseInt(qtyO.toString());
                }

                if (wt < 0) {
                    table.getModel().setValueAt(tcl.getOldValue(), tcl.getRow(), colNo);
                }

            } catch (Exception ex) {
                util.ShowMessage("Please enter the Numbers only", "Error!");
                table.getModel().setValueAt(tcl.getOldValue(), tcl.getRow(), colNo);
                ex.printStackTrace();
            }




        }

    }
};
TableCellListener tclProd = new TableCellListener(table, actionProd);