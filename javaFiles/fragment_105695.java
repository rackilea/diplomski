try {
    firstSet = Integer.parseInt(jTextField2.getText());
    secondSet = Integer.parseInt(jTextField3.getText());
} catch (NumberFormatException e) {
    jLabel1.setText("PIN NOT VALID; TRY AGAIN!!!");
}