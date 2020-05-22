public class Controller implements ActionListner {

    private JTextField myTextField;
    public Controller(JTextField myTextField){
        this.myTextField = myTextField;
    }

    @Override
    public void ActionPerformed(ActionEvent e){
        System.out.println(myTextField.getText());
    }
 }