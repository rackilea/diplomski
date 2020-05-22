private void putThreeBeepers() 
{
    for (int i = 0; i < 2; i++) {
        putBeeper();
        move();
    }

    putBeeper();
}

private void backUp() 
{
    turnAround();
    move();
    turnAround();
}