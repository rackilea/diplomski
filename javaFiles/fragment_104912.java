private void move()
{
    //....your other code
    if(canExecuteMovement(guy.getBounds(), guy.getXSpeed(), 0))
    {
        guy.moveX();
    }

    if(canExecuteMovement(guy.getBounds(), 0, guy.getYSpeed())
    {
        guy.moveY();
    }
}


private boolean canExecuteMovement(Bounds currentBounds, int xChange, int yChange)
{
    int projectedX = currentBounds.getX() + xChange;
    int projectedY = currentBounds.getY() + yChange;
    Bounds projectedBounds = new Bounds(projectedX, projectedY);
    // ^ Making an assumption about Bounds constructor but you get the idea

    for(int i = 0; i < platform.length; i ++)
    {
            if(projectedBounds.intersects(platform[i].getBounds())
            {
                    return false;
            }
    }

    return true;
}