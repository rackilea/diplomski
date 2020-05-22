import java.util.Comparator;
import java.util.PriorityQueue;

public class StackOverflow
{
    public static void main(String[] args)
    {

        FuelPriority strategy = new FuelPriority();
        PriorityQueue<Vehicle> incoming = new PriorityQueue<Vehicle>(4, strategy);
        incoming.add(new Vehicle("car1", 10));
        incoming.add(new Vehicle("car2", 20));
        incoming.add(new Vehicle("car3", 15));
        incoming.add(new Vehicle("car4", 1));

        // to retrieve the elements in order
        while (!incoming.isEmpty()) {
            System.out.println(incoming.poll());
        }

    }

}

class FuelPriority
    implements Comparator<Object>
{

    public int compare(Object o1, Object o2)
    {

        Vehicle a1 = (Vehicle)o1;
        Vehicle a2 = (Vehicle)o2;

        return Integer.compare(a1.getFuelLevel(), a2.getFuelLevel());
    }
}

class Vehicle
{

    private String name;
    private int fuelLevel;

    public Vehicle(String name, int fuelLevel)
    {
        this.name = name;
        this.fuelLevel = fuelLevel;
    }
    public int getFuelLevel()
    {
        return fuelLevel;
    }

    @Override
    public String toString()
    {
        return name + "=" + fuelLevel;
    }
}