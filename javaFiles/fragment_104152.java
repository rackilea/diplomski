private class LogInButtonHandler implements ActionListener
{
    int i = 0;
    @Override
    public void actionPerformed(ActionEvent e) {

    String password=null;
    String user=null;
    boolean isValid;

    if (i < 3) {
        isValid=isValidCred(user,password);
        if(isValid) {
            JOptionPane.showMessageDialog(null,"Welcome "+user,"Succesful",JOptionPane.INFORMATION_MESSAGE );
            return;
        }
        i++;
    }
    JOptionPane.showMessageDialog(null,"Username/Password Inccorect Please Try Again: "+i,"Error",JOptionPane.ERROR_MESSAGE);

    if(i==2) {
        JOptionPane.showMessageDialog(null,"This " +(++i) + "rd login will be your final attempt","Error",JOptionPane.ERROR_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null,"You had "+i+" failed attempts","Error",JOptionPane.ERROR_MESSAGE);
    }

}