public class MyJPanel1 extends JPanel { 

    private JButton localButton;

    private JButton remoteButton;

    public MyJPanel1(JButton localButton, JButton remoteButton){
        this.localButton= localButton;
        this.remoteButton = remoteButton;

        //add localButton to the JPanel

        //you can do, whatever you want with the remote (other panel) button.
        this.localButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                this.remoteButton.setText("I can reach you Button2"); 
            }
        }); 
    }
}