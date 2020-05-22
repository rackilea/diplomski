checkBoxes[i] = new JCheckBox("label");
textFields[i] = new JTextField("extra data");
// ...
if (checkBoxes[i].isSelected()) {
    updateFile(file, textFields[i]);
}