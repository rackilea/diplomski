// Creating checkboxes
String[] descriptions = { "Description 1", "Description 2", "Description 3"};
List<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();
for (String description : descriptions) {
    JCheckBox checkBox = new JCheckBox(description);
    checkBoxes.add(checkBox);
    jPanel.add(checkBox);
}