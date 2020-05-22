public static JButton [][] b = new JButton[3][3];
{ // Initialization code follows
    b[0][0].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String text = b[0][0].getText();
            if(text.equals("-")){
                b[0][0].setText("O");
                computerMove();
            }
            else{
                System.out.println("Pick Again");
            } } });
   // And so on for the other 8 buttons.
}