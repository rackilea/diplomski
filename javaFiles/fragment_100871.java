private List<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();
...
    while ((info = Buffer.readLine()) != null) {
        if (info != null) {
            JCheckBox check = new JCheckBox(info);
            panelFromFile.add(check);
            this.checkBoxes.add(check);
        }
    }

...
public void actionPerformed(ActionEvent e) {
    List<String> infos = new ArrayList<String>();
    for (JCheckBox checkBox : checkBoxes) {
        if (checkBox.isSelected() {
            infos.add(checkBox.getText());
        }
    }
    // TODO do something with infos
}