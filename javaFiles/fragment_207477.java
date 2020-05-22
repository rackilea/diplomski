ArrayList<Car> carsList = new ArrayList<>();
for (Customer cust : customers) {
    for (int i = 0; i < cust.cars.length; i++) {
        if (carsList.size() > i) {
           carsList.set(i, cust.cars[i]);
        } else {
           carsList.add(cust.cars[i]);
        }
    }   
}