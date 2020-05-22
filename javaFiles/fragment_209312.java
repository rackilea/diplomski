Map<String, List<Passenger>> routes = new HashMap<>();
for(Passenger passenger : passengers) {
    if(routes.containsKey(passenger.getId()) {
        List<Passenger> route = routes.get(passenger.getId());
        route.add(passenger);
    } else {
        List<Passenger> newRoute = new ArrayList<>();
        newRoute.add(passenger);
        routes.put(passenger.getId(), newRoute);
    }
}