Die[] returnedArray; // member variable

// Inside the container's constructor
throwButton.addActionListener(new MyActionListener());

public Die[] roll(){
    Die[] playerRoll = new Die[5];

    //code goes in here...
    return playerRoll;
}

// Your custom ActionListener
class MyActionListener implements ActionListener {
    @Override
    public void onActionPerformed(ActionEvent e) {
         returnedArray = roll();
    }
}