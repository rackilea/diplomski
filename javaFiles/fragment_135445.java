boolean pressed = false;
private void jButton1ActionPerformed (java.awt.event.ActionEven evt) {

if (!pressed) {
    jTextArea1.setText(jTextArea1.getText()+"Let the battle begin!\n");
    pressed = true;
}