public void actionPerformed(ActionEvent e) {
    //let's assume we are on rocks:
    setLeft(Gesture.ROCK);
    setRight(randomGesture());

    if(isEqualGesture()) {
        //write "draw" in your text box
    }else if(leftWins()){
        //player did win, write a notification
    }else if(rightWins()){
        //computer did win
    }
}