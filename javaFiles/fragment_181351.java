class MyFileChooser extends JFileChooser{
    public MyFileChooser() {
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2" }));
        JPanel panel = new JPanel();
        panel.add(comboBox);
        setAccessory(panel);
        //add(comboBox, BorderLayout.SOUTH);
   }
}