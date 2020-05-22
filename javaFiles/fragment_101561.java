public class ButtonAction{
    public static class AddInv implements ActionListener{
        private JTextArea text;
        public AddInv(JTextArea text) {
            this.text = text;
        }
        public void actionPerformed(ActionEvent e){
            AbstractButton inv = (AbstractButton)e.getSource();

            if(inv.getActionCommand().equals("SAVE")){
                invName = text.getText();                
                JOptionPane.showMessageDialog(null, invName);
            }   
        }
    }
}