public carsDTO updateCar(carDTO cars) {
    TypedQuery<myquerycalss> query = entitymanager.createNamedQuery("sqlName", myquerycalss.class);
    query.setParameter("name", cars.getName());
    query.setParameter("price", cars.getPrice());
    query.executeUpdate();
    ...
}