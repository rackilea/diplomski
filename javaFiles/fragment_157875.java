//PLAYER1 LEVEL FINISHING
 if( player.getBounds().intersects(levelfinish.getBounds())){
        message = "A winner is you!";
        if (soundPlayed == false) {
            try {
               playSound("D:/BadGame/Sounds/winner.wav");
               soundPlayed = true;
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }