private class theHandler implements ActionListener{//this class handles the events
                                         //waits for an event to happen and execute the code
    public void actionPerformed(ActionEvent event){//actionPerformed is a built-in method
                                                  //ActionEvent is also built-in
        /*...*/
        // Then you try and reference the instance variable which is null
        cl.show(setPanel, "MainMenu");

    }
}