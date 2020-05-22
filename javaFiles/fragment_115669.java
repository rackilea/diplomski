public static int getGuestCount() {
    int guests;
    while(true) {
        System.out.print("Enter number of guests: ");
        guests = input.nextInt();
        if (guests >= 1 && guests <= 100)
            break;
        else 
            System.out.println("The guest count must be at least 1, but does not exceed 100. Please enter again.");
    }
    return guests;
}
public static int getSlicesPerPerson() {
    int slicesPerPerson;
    while(true) {
    System.out.print("Enter number of slices per person: ");
    slicesPerPerson = input.nextInt();
    if (slicesPerPerson >= 1 && slicesPerPerson <= 8)
        break;
    else
        System.out.println("The pizza slice count must be at least 1, but does not exceed 8. Please try again.");
    }
    return slicesPerPerson;
}
public static double computeRoomCost(int guests) {
    double roomCost;
    if (guests <= 30)
        roomCost = 100.00;
    else
        roomCost = 200.00;
    return roomCost;
}
public static double computeSodaCost(int guests) {
    double sodaCost = guests * 1.50;
    return sodaCost;
}