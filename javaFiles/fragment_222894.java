public void actionPerformed(ActionEvent event) {
if(event.getSource() instanceof JButton){

    JButton clickedButton = (JButton) event.getSource();
    String buttonText = clickedButton.getText();

    if (buttonText.equals("2") || buttonText.equals("5") || buttonText.equals("6") || buttonText.equals("11")){
        int seatNum = Integer.parseInt(buttonText);     // you get the seat number into an integer.
                                                        //this only works if the text is actually representing a number
        entername.setVisible(true);
        seatnum.setVisible(true);
        confirmed.setVisible(true);
        inputline.setVisible(true);
        outputline.setVisible(true);
        inputline.setEditable(true);
        inputline.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();   // don't put code between this and if. 
                                            //No point doing something if the key is not enter

                if (key == KeyEvent.VK_ENTER) {             
                    Toolkit.getDefaultToolkit().beep();
                    String name = inputline.getText();
                    seat.arrangement[seatNum - 1] = name;
                    System.out.println(seat.arrangement[seatNum - 1]);
                    inputline.setEditable(false);
                    outputline.setText(buttonText);
                    clickedButton.setForeground(Color.black); // I'm guessing this is the button that got clicked?
                    for( ActionListener al : clickedButton.getActionListeners() ) {
                         clickedButton.removeActionListener( al );
                    }                           
                }
            }
        });
    }
}
}