public TicTacToeButton(int buttonNumber) { 
    // call the JButton super class constructor to initialize the JButtons 
    super(); 
    // set the name of the parameter to the data member of the JButton object  
    this.buttonNumber = buttonNumber; 
    // upon creating of the JButton the button will add ActionListener to itself 
    addActionListener(this); 
    setActionCommand(Integer.toString(buttonNumber));*************
}