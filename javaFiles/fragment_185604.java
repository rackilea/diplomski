public void avoidDoubles()
{
    while allCars.contains(car)
    {
        setCar(); // generate new, different car
    }
    allCars.add(car);
}