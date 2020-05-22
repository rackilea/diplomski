public static List<Vehicle> getVehicles (TreeSet tSet) {
    List<Vehicle> vehicleList = new ArrayList<Vehicle>();
    Iterator itr = tSet.iterator();
    while(itr.hasNext()) {
        Entry<Vehicle, Integer> e = itr.next();
        vehicleList.add(e.getKey());
    }

    return vehicleList;
}