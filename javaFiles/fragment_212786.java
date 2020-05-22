private Double distance; // changed from double to Double so it's nullable

public double getDistance() {
    if (distance == null) {
        distance = <calculate distance here>
    }

    return distance;
}