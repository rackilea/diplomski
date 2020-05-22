private class StartListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent arg0) {
        startFrame.setVisible(false); //close start window
        paintApp.go(); //the go function contains code for opening the 
                       //main window
                       //the paintApp is an object that contains both
                       //JFrames, starting and main 
    }
}