private JButton btn_Save;

btn_Save = new JButton(save);
        btn_Save.setText("Save Configuration");
        btn_Save.setBounds(20, 459, 290, 25);
        btn_Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn_Save) {
                    if(saveData()){
                        JOptionPane.showMessageDialog(btn_Save, "Event Configuration saved successfully!");
                    }
                    else{
                        JOptionPane.showMessageDialog(btn_Save, "Failed to save Event Configuration!");
                    }
                }
            }