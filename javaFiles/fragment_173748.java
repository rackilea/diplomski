interface Vehicle
{
    default public void Move()
    {
        System.out.println("Move");
    }
}

interface Bike extends Vehicle
{
    public void RideOnBackWheel();
}

interface VehicleWithEngine extends Vehicle
{
    public void EngineStart();
    public void EngineStop();
}

class Motorbike implements Bike, VehicleWithEngine
{
    private boolean engine = false;

    @Override
    public void EngineStart()
    {
        engine = true;
        System.out.println("Engine started.");
    }

    @Override
    public void EngineStop()
    {
        engine = false;
        System.out.println("Engine stopped.");
    }

    @Override
    public void RideOnBackWheel()
    {
        if(engine) { System.out.println("1 wheel"); }
    }

    @Override
    public void Move()
    {
        if(engine) { System.out.println("Motorbike.move()"); }
    }
}