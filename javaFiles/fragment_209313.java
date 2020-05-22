for(List<Passenger> route : routes.values()) {
    System.out.print(route.get(0).getId() + " | " + route.get(0).getRoute());
    for(Passenger passenger : route) {
        System.out.println(passenger.getMeal() + " | " + passenger.getFood());
    }
}