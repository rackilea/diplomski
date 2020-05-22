private void handlePylonPlacement()
{
    if(decrementMinerals(-100))
        addPopMax(9);
} 

private boolean decrementMinerals(int amount)
{ 
    if(MaxMinerals - amount >= 0) // prevent situation where you go into negative minerals
    {
         MaxMinerals -= amount;
         return true;
    }
    else
         return false;
}

private void addPopMax(int amount)
{
    if(popMax + amount <= MAX_POPULATION) // restrict addition to pop-max to a sane upper bound
         popMax += amount;
}

public boolean mouseDown(Event e, int x, int y) {
    if (numClicks == 10) {//Title screen        
        numClicks++;
        repaint();
    }

    if (numSquare == 0) {
        xCoord[numSquare] = x;
        yCoord[numSquare] = y;
        numSquare++;
        handlePylonPlacement(); // call your new handler
        repaint();
    }
    return true;
}