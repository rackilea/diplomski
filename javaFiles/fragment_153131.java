javax.swing.JButton[] listButton = new javax.swing.JButton[9];
for (int i = 0; i < listButton.length; i++) {
    javax.swing.JButton button = new javax.swing.JButton();
    button.setText("Buttton" + (i+1));
    //...other information
    listButton[i] = button;
}