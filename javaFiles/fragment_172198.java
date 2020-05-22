//simple stop
if(rectOne.intersects(rectTwo))
{
    player.xSpeed = 0;
    player.ySpeed = 0;
}

//variable-axis stop
if(rectOne.intersects(rectTwo))
{
    //depending on Rectangle implementation may need to use other method
    Rectangle overlap = rectOne.intersection(rectTwo);
    if (overlap.height >= overlap.width)
    {
        player.xSpeed = 0;
    }
    if (overlap.width >= overlap.height)
    {
        player.ySpeed = 0;
    }
}

//simple turn-around (about face)
if(rectOne.intersects(rectTwo))
{
    player.xSpeed *= -1;
    player.ySpeed *= -1;
}

//bounce (variable-axis turn around)
if(rectOne.intersects(rectTwo))
{
    Rectangle overlap = rectOne.intersection(rectTwo);
    if (overlap.height >= overlap.width)
    {
        player.xSpeed *= -1;
    }
    if (overlap.width >= overlap.height)
    {
        player.ySpeed *= -1;
    }
}