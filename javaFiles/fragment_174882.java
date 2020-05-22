public String coveredSearch(List<ParkingSpots> parkingSpots) {
        for (ParkingSpots p: parkingSpots) {
            if (!p.inUse && p.covered) {
                return p.name;
            }
        }
        return "Cannot find parking space";
    }