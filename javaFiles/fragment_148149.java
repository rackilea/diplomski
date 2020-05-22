public class Form1 extends JDialog {

    JTable currentPurchases;
    JButton addRecordButton;

    private initComponents() {
        addRecordButton = new JButton("Add record");
        addRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Form2 form2 = new Form2();
                form2.setForm1(this);
                form2.setVisible(true);
            }
        };
        ... // init the table and other components
    }

    public JTable getCurrentPurchasesTable() {
        return this.currentPurchases;
    }
}

public class Form2 extends JDialog {

    Form1 form1; // this variable will keep reference to a Form1 instance
    JButton saveRecordButton;

    private void initComponents() {
        saveRecordButton = new JButton("Save record");
        saveRecordButton .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                DefaultTableModel model = (DefaultTableModel) form1.getCurrentPurchasesTable().getModel();
                // add new rocord to the model
            }
        };
        ... // init the other components

    }

    public void setForm1(Form1 f) {
        this.form1 = f;
    }

}