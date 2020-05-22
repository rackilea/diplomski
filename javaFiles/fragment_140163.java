import java.util.Scanner;

class Trip {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the first name:");
    String nameOne = scanner.nextLine();

    System.out.print("Enter the second name:");
    String nameTwo = scanner.nextLine();

    System.out.print("Enter cost of flights:");
    double flightsCost = scanner.nextDouble();

    System.out.printf("Who paid for the flights? Enter 1 for %s or 2 for %s:", nameOne, nameTwo);
    int whoPaidFlights = scanner.nextInt();

    System.out.print("Enter cost of hotel:");
    double hotelCost = scanner.nextDouble();

    System.out.printf("Who paid for the hotel? Enter 1 for %s or 2 for %s:", nameOne, nameTwo);
    int whoPaidHotel = scanner.nextInt();

    System.out.print("Enter cost of tour:");
    double tourCost = scanner.nextDouble();

    System.out.printf("Who paid for the tour? Enter 1 for %s or 2 for %s:", nameOne, nameTwo);
    int whoPaidTour = scanner.nextInt();

    System.out.print("Enter cost of meals:");
    double mealsCost = scanner.nextDouble();

    System.out.printf("Who paid for the meals? Enter 1 for %s or 2 for %s:", nameOne, nameTwo);
    int whoPaidMeals = scanner.nextInt();

    double totalCost = flightsCost + hotelCost + tourCost + mealsCost;
    System.out.printf("Total bill for trip: %.2f \n", totalCost);

    // This stuff can be moved to a more appropriate place if you want to
    double personOnePaid = 0;
    if(whoPaidFlights == 1) personOnePaid += flightsCost;
    if(whoPaidHotel == 1) personOnePaid += hotelCost;
    if(whoPaidTour == 1) personOnePaid += tourCost;
    if(whoPaidMeals == 1) personOnePaid += mealsCost;

    double personTwoPaid = totalCost - personOnePaid;

    System.out.printf("%s owes: %.2f \n", nameOne, personOnePaid);
    System.out.printf("%s owes: %.2f \n", nameTwo, personTwoPaid);
  }
}