// You are adding an ActionListener to the button
//Using the method addActionListener and a anonymous inner class
button.addActionListener(new ActionListener() {//anonymous inner class

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        button.setText("Text modified by an event called ActionEvent!");
    }
});