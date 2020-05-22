public class handlerClass implements ActionListener{
    public void actionPerformed(ActionEvent event){
      swingAppLogic(textField.getText());
        JOptionPane.showMessageDialog (null, sumAsString, "Title", JOptionPane.INFORMATION_MESSAGE);
    }
}