public void vJump(Entity entity, Location loc, double time)
{
    this.entity = entity;
    entity.setVelocity(getV(entity.getLocation(), loc, time));
}

private Vector getV(Location p1, Location p2, double t)
{
    double x = p2.getX() - p1.getX();
    double y = p2.getY() - p1.getY();
    double z = p2.getZ() - p1.getZ();
    double gravity = 0.1;
    return new Vector(getVelocity(x,0,t), getVelocity(y,gravity,t), getVelocity(z,0,t));
}

private double getVelocity(double d, double a, double t)
{
    a*=-.5;
    a*=Math.pow(t,2);
    d-=a;
    return 2*(d/t);
}