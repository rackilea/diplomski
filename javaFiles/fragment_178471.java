String gender = new String();
        if (jRadioButton1.isSelected()) {
            gender = jRadioButton1.getActionCommand();
        } else if (jRadioButton2.isSelected()) {
            gender = jRadioButton2.getActionCommand();
        } else {
            jGndrErrorLabel.setText("Select gender.");
            jGndrErrorLabel.setForeground(Color.red);
        }