public class CustomizedButton extends Button{
    String customClass;

    CustomizedButton(String stringToPrint){
        super(customClass); //customClass is also button name
        this.customString = stringToPrint;
        addActionListener(new MyListener());
    }

    private class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: listener code here
        }
    }
}