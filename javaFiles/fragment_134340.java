@Override
public void update(GameContainer gc, StateBasedGame s, int delta)
        throws SlickException {

    // .......

    if (moving)
    {
        if (movingDirection == DIR_RIGHT)
        {
            if (xCoord >= targetCoord)
            {
                xCoord = targetCoord;
                moving = false;
            }
            else
            {
                xCoord += delta * 0.1f;
                characterAnimation.update(delta);
                if (xCoord > Window.WIDTH - 32)
                {
                    xCoord = Window.WIDTH - 32;
                }
            }
        }
        else if (movingDirection == DIR_LEFT)
        {
            if (xCoord <= targetCoord)
            {
                xCoord = targetCoord;
                moving = false;
            }
            else
            {
                xCoord -= delta * 0.1f;
                characterAnimation.update(delta);
                if (xCoord < 0)
                {
                    xCoord = 0;
                }
            }
        }
        else if (movingDirection == DIR_UP)
        {
            if (yCoord <= targetCoord)
            {
                yCoord = targetCoord;
                moving = false;
            }
            else
            {
                yCoord -= delta * 0.1f;
                characterAnimation.update(delta);
                if (yCoord < 0)
                {
                    yCoord = 0;
                }
            }
        }
        else if (movingDirection == DIR_DOWN)
        {
            if (yCoord >= targetCoord)
            {
                yCoord = targetCoord;
                moving = false;
            }
            else
            {
                yCoord += delta * 0.1f;
                characterAnimation.update(delta);
                if (yCoord > Window.WIDTH - 32)
                {
                    yCoord = Window.WIDTH - 32;
                }
            }
        }
    }
}