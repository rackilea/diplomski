public static double drivingCost(double drivenMiles, double dollarsPerGallon, double milesPerGallon)
{
    double totalCost = 0;
    totalCost = (drivenMiles / milesPerGallon) * dollarsPerGallon ;
    System.out.printf("%.2f", totalCost);
    System.out.print(" "); // <-------- here!
    return totalCost;
}