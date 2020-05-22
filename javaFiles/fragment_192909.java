final JComboBox petList = new JComboBox(petStrings);
petList.setSelectedIndex(2);

JButton submit = new JButton("Submit");
submit.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String petName = (String) petList.getSelectedItem();
        System.out.println(petName);
    }
});