int lastSpeedIncrease = -1;  //class or 'global' variable
//initialize to -1 and not 0

public void scoreMethod(){               
    if(GameClass.score > lastSpeedIncrease){
        if(GameClass.score % 500 == 0){
            speed++;
            lastSpeedIncrease = GameClass.score;
        }
     }
}