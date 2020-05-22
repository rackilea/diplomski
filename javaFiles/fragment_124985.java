public class ATMGUI extends GUI {

    public ATMGUI() {
        //...
        button.addActionListener(new WithdrawListener());  
        //...
    }

    class WithdrawListener implements ActionListener {

        public void actionPerformed(ActionEvent click) {
            System.out.println("This is a test.");
        }
    }