public void setHasTarget(boolean hasTargetIn)
{
    if (hasTargetIn)
    {
        deltaX = getTargetX() - getX();
        deltaY = getTargetY() - getY();
        direction = Math.atan(deltaY / deltaX); // Math.atan2(deltaY, deltaX) does the same thing but checks for deltaX being zero to prevent divide-by-zero exceptions
        speed = 5.0;
    }
    hasTarget = hasTargetIn;
}

public void setNext()
{
    setX(getX() + (speed * Math.cos(direction)));
    setY(getY() + (speed * Math.sin(direction)));
}