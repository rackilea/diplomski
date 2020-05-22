private void NineActionPerformed(java.awt.event.ActionEvent evt) {                                     
if(equalPress){        
textField.setText(9);
equalPress=false;

    }
else
textField.setText((Integer.parseInt(TextField.getText()) + 9));
}