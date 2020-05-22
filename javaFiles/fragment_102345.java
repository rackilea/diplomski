public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Horizontal", "Vertical"}));
        String P1_direction = comboBox.getSelectedItem().toString();

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Horizontal", "Vertical"}));
        String P2_direction = comboBox_1.getSelectedItem().toString();

        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}));
        String P1_x = comboBox_2.getSelectedItem().toString();
        int P1_coordinate_x = Integer.parseInt(P1_x);

        JComboBox comboBox_3 = new JComboBox();
        comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}));
        String P1_y = comboBox_3.getSelectedItem().toString();
        int P1_coordinate_y = Integer.parseInt(P1_y);

        JComboBox comboBox_4 = new JComboBox();
        comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}));
        String P2_x = comboBox_4.getSelectedItem().toString();
        int P2_coordinate_x = Integer.parseInt(P2_x);

        JComboBox comboBox_5 = new JComboBox();
        comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}));
        String P2_y = comboBox_5.getSelectedItem().toString();
        int P2_coordinate_y = Integer.parseInt(P2_y);

    }
});