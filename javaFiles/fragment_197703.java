final TableModelListener modelListener = new TableModelListener() {
    ...
};
final JComboBox comboBox = new JComboBox();
comboBox.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        switch (comboBox.getSelectedIndex()) {
            case 0: {
                model.removeTableModelListener(modelListener);
                break;
            }
            case 1: {
                model.addTableModelListener(modelListener);
            }
        }
    });