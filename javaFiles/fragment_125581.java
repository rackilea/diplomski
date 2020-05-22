public void addTable(Long restaurantId, RestaurantTable table) {
    Session session = this.sessionFactory.getCurrentSession();
    Restaurant restaurant = (Restaurant)session.load(Restaurant.class, restaurantId);
    table.setRestaurant(restaurant);
    session.save(table);
}