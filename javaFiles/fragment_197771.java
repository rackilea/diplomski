jPanel1.setVisible(false);
jPanel2.setVisible(false);
jPanel2.setVisible(false);
switch (jComboBox1.getSelectedItem().toString()) {
    case "Pane 1":
        jPanel1.setVisible(true);
        break;
    case "Pane 2":
        jPanel2.setVisible(true);
        break;
    case "Pane 3":
        jPanel3.setVisible(true);
        break;
}