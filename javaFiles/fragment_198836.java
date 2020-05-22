private class OkButtonHandler implements ActionListener {
public void actionPerformed (ActionEvent e) {
    String prompt = passwordTF.getText();
            if (prompt.equals("Computer")) {
                passwordTF.setText("");
                JOptionPane.showMessageDialog(null , "Access granted" , "Password" , JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                tries--;
                if (tries != 0){
                passwordTF.setText("");
                JOptionPane.showMessageDialog(null , "Access denied: "+(tries) , "Password" , JOptionPane.WARNING_MESSAGE);
                }
                 else {
                     passwordTF.setText("");
                     JOptionPane.showMessageDialog(null , "Access denied: System blocked" , "Password" , JOptionPane.WARNING_MESSAGE);
                     System.exit(0);
                 }
            }
        }
}