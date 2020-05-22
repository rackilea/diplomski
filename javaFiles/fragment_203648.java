public class Car
{
    // visible inside whole class
    private int speed;
    private int weight;

    // constructor parameters are only visible inside the constructor itself
    public Car(int sp, int w)
    {
        speed = sp;
        weight = w;
    }

    public int getSpeed()
    {
        // only 'speed' and 'weight' are usable here because 'sp' and 'w' are limited to the constructor block
        return speed;
    }
}