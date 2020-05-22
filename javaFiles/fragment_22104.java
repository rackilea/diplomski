private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String text = jTextField.getText();
        if (text != null && text.indexOf("-") == 0) {
            text = "+" + text.substring(1, text.length());
        } 
        else if (text != null && text.indexOf("+") == 0) {
            text = "-" + text.substring(1, text.length());
        }
        else {
            text = "-"+(text != null ? text : "");
        }
        jTextField.setText(text);
    }