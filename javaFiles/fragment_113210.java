Map<Int, Double> floorAreas = new HashMap<>();

// Implement this method for all types of rooms, since they are hardcoded
public void setBedroom(Room bedroom) {
    double savedArea = 0;
    int currFloor = bedroom.getFloor();
    if (floorAreas.containsKey(currFloor))
        savedArea += floorAreas.get(currFloor);

    savedArea += bedroom.getArea();
    this.bedroom = bedroom;
    floorAreas.put(currFloor, savedArea);
}

public double getFloorArea(int floorNumber) {
    return floorAreas.get(floorNumber);
}