public class VehicleComponent extends JComponent
{
    private int x;
    private int y;

    private int ccount = 0;    // these shouldn't be static
    private int tcount = 0;   

    private boolean[] truckOrCar; // simple boolean array (you can change the type as you add more vehicles...)

    public VehicleComponent() {
        // figure out your car/truck count here
        Random rand = new Random();
        truckOrCar = new boolean[10];

        for (int i = 0; i<10; i ++)
        {
            int vehic = rand.nextInt(2);
            if (vehic == 0)
            {
                // false for car
                truckOrCar[i] = false;
                ccount += 1;
            }
            else {
                // true for truck
                truckOrCar[i] = true;
                tcount += 1;
            }
        }
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        Random rand = new Random();

        // here just look in your list for what to draw
        for (int i = 0; i<10; i ++)
        {

            // false for car
            if ( !truckOrCar[i] )
            {
                x = rand.nextInt(420);
                y = rand.nextInt(545);

                Vehicle car = new Car(x, y);
                car.draw(g2);
                ccount += 1;
            }
            // true for truck
            else
            {
                x = rand.nextInt(420);
                y = rand.nextInt(545);
                Vehicle truck = new Truck(x, y);
                truck.draw(g2);
                tcount += 1;
            }
        }
    }

    public String toString()
    {
        return "Trucks: " + tcount + ", Cars: " + ccount;
    }

}