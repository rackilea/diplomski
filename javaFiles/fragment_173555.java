public int winCraps{
    roll = rollDice();
    if (roll == 7 || roll == 11) {
        return true;
    }
    else if(roll == 2 || roll == 3 || roll == 12) {
        return false;
    }
    else{
        return rollforPoint(roll);
    }
}