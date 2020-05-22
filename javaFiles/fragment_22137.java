for (int i = 0; i < dock1.length; i++) {
    if (dock1[i] != null && dock1[i].getShipName().equals(name)) { //ONLY FINDING in ARRAY 0
                      dock1[i] = null;
        System.out.println("Ship removed");
        /// HERE CHECK IF SHIP IN DOCK
        for (int j = 0; j < waitingList.length; j++) {
            if (dock1[i] == null && waitingList[j] != null) {
                // Add ship to the dock
                dock1[i] = new Ship(waitingList[j].getShipName(), waitingList[j].getShipSize());
                System.out.println("Move ship from waiting list to dock 1");
                waitingList[j] = null;
                return;
            } else {
             //   System.out.println("No space in dock, go on in waiting list");
              // NO RETURN HERE
            }
        }
    } else {
        System.out.println("Ship not docked here, try next dock if there is one left");
        // NO BREAK HERE
    }
}
System.out.println("Ship not docked in any dock");