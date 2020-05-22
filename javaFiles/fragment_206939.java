List<AircraftCarrier> myList = new ArrayList<AircraftCarrier>();
 for (int j = 1; j < 4; j++) {
    int parkingSlot= 1 + rd.nextInt(3);
    AircraftCarrier ac= new AircraftCarrier (fc, j, parkingSlots, parkingSlots);
    myList.add(ac);
}