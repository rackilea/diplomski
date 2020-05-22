for(int i = oldCars.size() - 1; i >= 0; i--)
{
    if(oldCars.get(i).getVelocity().length() > 0.0f)
    {
        oldCars.get(i).update(timeStep);
    }
    else
    {
        oldCars.remove(i);
    }
}