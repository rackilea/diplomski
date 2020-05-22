if (buttonObj == guess){
        double g = yourGuess.getNumber();
            if ((g > 0)&&(g < 11)){
                String startGameStr = Game.StartGame(g);
                label3.setVisible(false);
                yourGuess.setEnabled(false);
                label1.setText(startGameStr);
            }else{
                label3.setVisible(true);
                yourGuess.requestFocus(true);
            }
    }