setUpGame();
game();
cleanUpAfterGame();

setUpGame() {
    chooseWord();
    paintBasicHangman();
}

game() {
    while (alive) {
        readLetterFromUser();
        if (missedLetter) {
            paintNextPartOfHangman();
        } else {
            redraw();
            if (won()) {
                return true;
            }
        }
    }
    return false;
}

controller() {
    do {
        setUpGame();
        game();
        cleanUpAfterTheGame(); //optional
        wantsNewGame?();
    } while (userWantsToPlay)