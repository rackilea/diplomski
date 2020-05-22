JComboBox comboBox1 = new JComboBox(items1);
    comboBox1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox)e.getSource();
            String value = (String)cb.getSelectedItem();
            table.setValueAt(value, 0, 0);
        }
    });