position += velocity;
//make sure the ship cannot go further than the bounds
//but also make sure that the ship doesn't stand still with large velocities
if (position > 6)
{
    velocity = -velocity;
    position = 6;
}
if (position < -6)
{
    velocity = -velocity;
    position = -6;
}