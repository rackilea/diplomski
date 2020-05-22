static void gameLoop(){
    boolean loop = true;

    while(loop==true){
        displayBoard();
        playerMove();
        if(checkIfWin() == true){
            loop = false;
        }

        if(checkIfLose() == true)
            loop = false;

        If(loop){
            computerInput();
        }
    }

}