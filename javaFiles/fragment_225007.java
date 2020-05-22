public class Controller implements ActionListner {
    private String text;

    public Controller(String text){
        this.text = text;
    }

    @Override
    public void ActionPerformed(ActionEvent e){
        System.out.println(text);
    }
 }