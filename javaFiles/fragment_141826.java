public class myClass{
    public enum UserChoice{
        Yes, No
    }

    UserChoice userChoice;

    public void addAction(){
        JButton btnYes = new JButton();

        btnYes.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
                userChoice = UserChoice.Yes;
                dlg.dispose();
            }
        });
    }
}