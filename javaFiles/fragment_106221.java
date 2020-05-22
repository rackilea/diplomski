public static void main(String[] args) {
    final int maxPassengers = 67;

    double random = Math.random() * 69 + 1;
    String q;
    Scanner in = new Scanner(System.in);
    String[][] PlaneTicket = new String[maxPassengers][4];

    for (int row = 0; row < maxPassengers; row++) {
        System.out.print("Enter name:");
        PlaneTicket[row][0] = in.next();

        System.out.print("Enter surname: ");
        PlaneTicket[row][1] = in.next();

        System.out.print("Enter a ID: ");
        PlaneTicket[row][2] = in.next();

        // you should keep the SeatNumber
        PlaneTicket[row][3] = String.valueOf(Math.round(random));

        System.out.println("************Airport**********");
        System.out.println("Seat number: " + PlaneTicket[row][3]);
        System.out.println("Name: " + PlaneTicket[row][0]);
        System.out.println("Surname: " + PlaneTicket[row][1]);
        System.out.println("ID: " + PlaneTicket[row][2]);
        System.out.println("*****************************");

        System.out.println("Do you want to view the passanger list: " + "(Yes/No)");
        q = in.next();

        if ("Yes".equalsIgnoreCase(q) || "y".equalsIgnoreCase(q)) {
            System.out.println("Name     Surname     ID     Seat Number");
            System.out.println("----------------------------------------");

            for (int k = 0; k <= row; k++) {
                System.out.println(PlaneTicket[k][0] + "    " + PlaneTicket[k][1] + "      " + PlaneTicket[k][2] + "    " + PlaneTicket[row][3]);
            }
        }
    }
}