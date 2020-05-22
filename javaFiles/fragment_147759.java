boolean playerOne = true;
boolean haveWinner = false;

while (!haveWinner) {   
    if (playerOne) {
        /*player one's turn - do something */
        playerOne = false;
    } else {
        /* player two's turn - do something */
        playerOne = true;
    }
}