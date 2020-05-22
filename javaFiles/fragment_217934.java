for(int i=0;i<tbm.length;i++) {
    final int tblIdx = i;
    addRow[i] = new JButton("Add Row");
    selectionModel = tables[i].getSelectionModel();
    currentUser=i;
    addRow[i].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Object[] temp = {"",""};
            tbm[tblIdx].addRow(temp);
            selectionModel.setSelectionInterval(tbm[tblIdx].getRowCount()-1,tbm[tblIdx].getRowCount()-1);
        }
    });
}