JComboBox comboBox_1; //you need to declare the comboBox and textField before the ActionListener.
comboBox.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        String[] v = a.getStudentID(comboBox.getSelectedItem().toString());
        comboBox_1.setModel(new DefaultComboBoxModel<String>(v));

        String y = a.getStudentName(comboBox_1.getSelectedItem().toString());
        textField_3.setText(y);
    }
});