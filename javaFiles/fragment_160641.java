static void BtnAction(Button pressed, Button... neighbors) {
    for (Button neighbor : neighbors) {
        if (!neighbor.isVisible()) {
            neighbor.setText(pressed.getText());
            neighbor.setVisible(true);
            pressed.setVisible(false);
            break;
        }
    }
}

private void Btn1ActionPerformed(java.awt.event.ActionEvent evt) {
    BtnAction(Btn1, Btn2, Btn4);
}

private void Btn2ActionPerformed(java.awt.event.ActionEvent evt) {
    BtnAction(Btn2, Btn3, Btn1, Btn5);
}

private void Btn3ActionPerformed(java.awt.event.ActionEvent evt) {
    BtnAction(Btn3, Btn2, Btn6);
}

// and so on...