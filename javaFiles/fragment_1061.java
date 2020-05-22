// On button press
for (JCheckBox checkBox : checkBoxes) {
    if (checkBox.isSelected()) {
        otherJPanel.add(new JLabel(checkBox.getText()));
    }
}