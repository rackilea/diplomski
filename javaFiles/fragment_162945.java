public void actionPerformed(ActionEvent e) {
    if (operateur == "") { 
        Value = Value.trim() + 6.0;
    } else {
        Value2 = Value2.trim() + 6.0;
    }
    s = tot.getText();
    tot.setText(s+"6");
}