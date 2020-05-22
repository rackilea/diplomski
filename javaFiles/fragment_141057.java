public abstract class Behavior
{
    public abstract void initBehavior();
    public abstract void updateBunny(GameObject bunny);
}

public class JumpBehavior extends Behavior
{
    private long hopFrequency = 1000; //1 hop / 1000 milliseconds.
    private double maximumHeight = 20, movementVelocity = 0;

    public JumpBehavior(long hopFrequency, double maximumHeight, double movementVelocity)
    {
        this.hopFrequency = hopFrequency;
        this.maximumHeight = maximumHeight;
        this.movementVelocity = movementVelocity;
    }

    private long previousTimeMillis = 0;
    private long elapsedTimeMillis = 0;
    private long timeSinceHop = 0;

    public void initBehavior()
    {
        //Start the clock.
        previousTimeMillis = System.currentTimeMillis();
        elapsedTimeMillis = System.currentTimeMillis();
    }

    public void updateBunny(GameObject bunny)
    {
        //Implement logic to control bunny here.
        //Consider some randomization using a Random Number Generator.

        //Keep track of time.
        elapsedTimeMillis = System.currentTimeMillis() - previousTimeMills;

        //If velocity is negative, then we move left.
        bunny.X += movementVelocity * elapsedTimeMillis;

        timeSinceHop += elapsedTimeMillis;
        if (timeSinceHop >= hopFrequency)
        {
            //Reset counter, but keep the extra milliseconds passed.
            timeSinceHop -= hopFrequency;

            //Apply an acceleration to the bunny to start the hop.
            //Maybe add logic to make sure it doesn't hop while in the air.
            bunny.Velocity.Y += maximumHeight;
        }

        previousTimeMillis = elapsedTimeMillis;
    }
}