while(true) {
    // initialization

    int pickup_delivery = readInt("Press 1 for delivery or 2 for pickup.");
    cont = readString("Press Y to continue or N to cancel.");

    if (cont.equalsIgnoreCase("n"))
        continue; // goes to beginning of loop; restarts the questionaire
}