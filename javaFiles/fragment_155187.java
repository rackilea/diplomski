if(ballPong.getPosition().y<= 1 || resetButton == true){
    player2Score = player2Score +1;
    System.out.println("bottom");
    resetButton = true;
    StartAgain();
    if(ballPong.reset ==true){
        ballPong.reset();
    }           
}