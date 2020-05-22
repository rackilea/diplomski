public class MyAppAssignment3
{
    public static void main (String[] args)
    {
        System.out.println("Scenario 1");
        Car nova1 = new Car();
        nova1.start();
        nova1.showState();
        nova1.drive();
        nova1.stop();   
        nova1.showState(); 
        System.out.println("");

        System.out.println("Scenario 2");
        Car nova2 = new Car();
        nova2.showState();
        nova2.drive();
        nova2.stop();
        nova2.showState();
        System.out.println("");

        System.out.println("Scenario 3");
        Car nova3 = new Car();
        nova3.showState();
        nova3.start();
        nova3.showState();
        nova3.stop();
        nova3.showState();
        nova3.drive();
        nova3.stop();
    }
}

class Car
{
    private boolean isStarted;
    private boolean isDriving;
    private boolean isStopped;
    private String showState;

    public Car()
    {
        isStarted = false;
        isDriving = false;
        isStopped = true;
    }

    public void start()
    {
        if(isStarted == false)
        {
            isStopped = false;
            isStarted = true;
            showState();
        }
        else
        {
            System.out.println("You can't start a car which is already started.");
        }

    }

    public void drive()
    {
        if(isStarted)
        {
            isDriving = true;
            showState();
        }
        else
        {
            System.out.println("You can't drive a car which is not started.");
        }

    }

    public void stop()
    {
        if(isStarted)
        {
            isStarted = false;
            isDriving = false;
            isStopped = true;
            showState();
        }
        else
        {
            System.out.println("You can't stop a car which is not started.");
        }

    }

    public String showState()
    {
        if(isStarted && (isDriving == false))
        {
            showState = "started";
        }
        else if(isStarted && isDriving)
        {
            showState = "driving";
        }
        else if(isStopped)
        {
            showState = "stopped";
        }
        System.out.println("The car is " + this.showState + ".");
        return showState;
    }

}