final JCheckBox DocumentCheckBox = new JCheckBox("Document");
final JCheckBox FilecheckBox = new JCheckBox("File");
ProduceDataDropDown.disable();
DocumentCheckBox.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {

        FilecheckBox.setSelected(false);
    }
});     
DocumentCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
DocumentCheckBox.setBounds(184, 131, 123, 23);
contentPane.add(DocumentCheckBox);


FilecheckBox.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

        DocumentCheckBox.setSelected(false);
    }
});
FilecheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
FilecheckBox.setBounds(184, 157, 123, 23);
contentPane.add(FilecheckBox);