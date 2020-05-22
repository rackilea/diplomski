@Override
    public void wonGame(HangManModelEvent evt) {

        playAgain("You won");

    }

    @Override
    public void lostGame(HangManModelEvent evt) {

        playAgain("You lost");

    }