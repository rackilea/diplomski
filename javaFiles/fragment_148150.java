public class Form1 extends JDialog {

    JTable currentPurchases;
    JButton addRecordButton;

    private initComponents() {
        addRecordButton = new JButton("Add record");
        addRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Form2 form2 = new Form2();
                form2.setTableModel(currentPurchases.getModel());
                form2.setVisible(true);
            }
        };
        ... // init the table and other components
    }
}

public class Form2 extends JDialog {

    TableModel model; // this variable will keep reference to a TableModel instance
    JButton saveRecordButton;

    private void initComponents() {
        saveRecordButton = new JButton("Save record");
        saveRecordButton .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // add new rocord to the model:
                ((DefaultTableModel)model).addRow(...);                    
            }
        };
        ... // init the other components

    }

    public void setTableModel(TableModel m) {
        this.model = m;
    }

}