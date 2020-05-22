public float getPitch()
{
    return (position.X - center.X) * MathHelper.PIOVER180;
}

public float getYaw()
{
    return (position.Y - center.Y) * MathHelper.PIOVER180;
}