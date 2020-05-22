public class MyAction implements ActionListener{
    String m;

    public MyAction(String radioButtonLabel){
        m = radioButtonLabel;
    }
    public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(null,
                "Your Selection is"+m+" radio button.");
    }
    public String getString(){
        return m;
    }
}