Scanner sc = new Scanner(System.in);

int senderStreetNumber;
boolean ok = false;

while(!ok) {
    System.out.println("Write the street number of the sender: ");
    try {
        senderStreetNumber = Integer.parseInt(sc.nextLine());
        ok = true;
    } catch (NumberFormatException nfe) {
        System.out.println("ERROR! Please enter a number.");
    }
}