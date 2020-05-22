class Game {

    /*
     * controller - main logic
     */
    void startEasyGame() {
        // initialize cards array, shuffle if needed

        // we start with zero cards flipped
        int flippedCards = 0;

        // main loop
        while (flippedCards != mCards.length) {
            // 1. show updated UI
            mBoard.showUpdatedCards();

            // 2. request player move 
            // and block current thread to wait till move is done
            // the result of the move - index of the card
            int index1 = requestMove();
            // temporarily flip first card face-up
            mCards[index1].flip();
            // show it on screen
            mBoard.showUpdatedCards();

            // same for second card
            int index2 = requestMove();
            mCards[index2].flip();
            mBoard.showUpdatedCards();


            // 3. check the result
            if (mCards[index1].getCardNum() == mCards[index2].getCardNum()) {
                // hooray, correct guess, update count
                // possibly show some encouraging feedback to user
                flippedCards += 2;
            } else {
                // incorrect, flip cards back face down
                mCards[index1].flip();
                mCards[index2].flip();
            }

        } // end of while loop

        // game ended -> show score and time
        mBoard.showResult();    
    }

}