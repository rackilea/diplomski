public class CustomizedButton extends Button{
    String customClass;

    CustomizedButton(String stringToPrint){
        super(customClass); //customClass is also button name
        this.customString = stringToPrint;
        addActionListener(e -> myListenerCode(e));
    }

    private void myListenerCode(ActionEvent e) {
        // TODO: listener code here
    }

}