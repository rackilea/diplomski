import java.util.*;

public class HighFly {

    public static void main(String[] args) {

        Flight indigo = new Flight("Indigo", 1000, "Trivandrum", "Dubai", 25000);
        Flight emirates = new Flight("Emirates", 1001, "Dehi", "US", 30000);
        Flight airindia = new Flight("Air India", 1002, "Kochi", "Malaysia",
                29000);

        ArrayList<Flight> flightList = new ArrayList<Flight>();
        flightList.add(indigo);
        flightList.add(emirates);
        flightList.add(airindia);

        System.out
                .println("FlightId       FlightName         Source            Destination        Fare");
        for (Flight flightObject : flightList) {
            System.out.print(flightObject.getFlightId());
            System.out.print("\t\t" + flightObject.getFlightName());
            System.out.print("\t\t" + flightObject.getSource());
            System.out.print("\t\t" + flightObject.getDestination());
            System.out.println("\t\t" + flightObject.getFlightFare());
        }

        // SEARCHING FLIGHT EXISTS
        System.out.println("Enter flight id");
        Scanner scanner = new Scanner(System.in);
        int checkFlightId = scanner.nextInt();
        for (Flight flightObject : flightList) {
            if (flightObject.searchFlight(flightObject.flightId, checkFlightId)) {
                System.out.println("Success");

            } else {
                System.out.println("Not success");

            }
        }

        // *********sorting***********
    for (Flight flightObject : flightList) {
            Collections.sort(flightList, new Compareid());
    }

        System.out.println("     after sorting       ");
        System.out
                .println("FlightId       FlightName         Source            Destination        Fare");
        for (Flight flightObject : flightList) {
            System.out.print(flightObject.getFlightId());
            System.out.print("\t\t" + flightObject.getFlightName());
            System.out.print("\t\t" + flightObject.getSource());
            System.out.print("\t\t" + flightObject.getDestination());
            System.out.println("\t\t" + flightObject.getFlightFare());
        }

    }

}