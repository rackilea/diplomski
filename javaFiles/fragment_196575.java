// Checks array using tieCheck from Methods class for a tie
    public void tieCheck(int turncount) {

        if (turncount == 4 && method.tieCheck() == true) {

            disable();
            label.setText("It's a tie!");
        }
    }