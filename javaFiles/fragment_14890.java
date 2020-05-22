for (int i = 0;i< ParkingDests; i++){
    for (int j = 0;j< ParkingDests; j++){

        <code>
        second = TravelTime.get(ParkingDests[i])
        if(second == null) {
            second = new HashMap<String, Object>()
            TravelTime.put(ParkingDests[i], second);
        }
        second.put(ParkingDests[j],Shortest);
        </code>

    }
}