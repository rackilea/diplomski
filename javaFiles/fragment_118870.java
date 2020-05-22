public static double drivingCost(double drivenMiles, double dollarsPerGallon, double milesPerGallon, boolean isLastCall)
{
    double totalCost = 0;
    totalCost = (drivenMiles / milesPerGallon) * dollarsPerGallon ;
    System.out.printf("%.2f", totalCost);

    if (!isLastCall) {
        System.out.print(" ");
    }
    return totalCost;
}