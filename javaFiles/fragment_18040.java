//private variable here so we could find and book seat through method findAvailableSeat()
private static int[][] table = { { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
        { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, { 20, 20, 20, 20, 20, 20, 20, 20, 20, 20 },
        { 20, 20, 20, 20, 20, 20, 20, 20, 20, 20 }, { 30, 30, 30, 30, 30, 30, 30, 30, 30, 30 },
        { 40, 40, 40, 40, 40, 40, 40, 40, 40, 40 }, { 40, 40, 40, 40, 40, 40, 40, 40, 40, 40 },
        { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 }, };
public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    boolean done = false;
    // initial seating chart

    while (!done) {
        int row;
        int col;
        // search seating chart
        System.out.printf("Enter maximum amount that you would like to spend on the tickets: ");
        int amount = in.nextInt();
        if (10 <= amount && amount < 20) {
            String location = findAvailableSeat(10);//store the indexes in a variable to show the user later
            if(location != null) {
                String[] locationList = location.split(",");
                row = Integer.parseInt(locationList[0]);
                col = Integer.parseInt(locationList[1]);
                System.out.printf("Ticket located at Row %d Seat %d purchased for 10\n", row + 1, col + 1);
                System.out.print("Would you like to purchase additional tickets? (Y/N) ");
                String resp = in.next(); //this statement is needed as sometimes with in.next() rushes to user input without printing text
                if (resp.equals("Y")) {
                    done = false;
                } else {
                    done = true;
                }
            }
            else 
                System.out.printf("No available seat found\n");
        }
    }
}