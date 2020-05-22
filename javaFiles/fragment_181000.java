class CarDealerShip
{
    public String printAllCarsOfColor(String shade)
    {
        String s = "";

        for(int z = 0; z < i; z++)
        {
            if (cars[z] instanceof NewCar)
            {
                NewCar nc = (NewCar)cars[z];
                if (nc.color.equals(shade))
                {
                    s += "Car " + (z + 1) + "\n" + nc.toString();
                }
            }
        }
        return s;
    }
}