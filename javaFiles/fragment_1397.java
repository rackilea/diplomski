private Runnable resetBoard() {
    return new Thread() {
        @Override
        public void run() {
            synchronized(this){
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        buttons[i][j].setText("");
                    }
                }
                notify();
            }                
        }
    }
}

private void computerMove(Thread resetBoard) {
    resetBoard.start();

    synchronized(resetBoard){
        try{
            System.out.println("Resetting board...");
            resetBoard.wait();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Board is reset.");

        // ...
        // existing computerMove() logic here
        // ...
    }
}

public void draw() {
    Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
    // resetBoard(); -- don't call here
    playerOneMove = !playerOneMove;
    switchPlayerTurn();
    if (!playerOneMove){
        firstComputerMove = true;

        // pass the result of resetBoard (new thread) here
        computerMove(resetBoard());
    }
}