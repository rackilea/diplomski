private void txtAdvanceKeyReleased(java.awt.event.KeyEvent evt) {
    double gtotal = parseDouble(txtGtotal.getText());
    double ad = parseDouble(txtAdvance.getText());
    double due = gtotal - ad;
}

private double parseDouble(String s){
    if(s == null || s.isEmpty()) 
        return 0.0;
    else
        return Double.parseDouble(s);
}