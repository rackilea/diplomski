private List<Restaurant> restaurants = new ArrayList<>();

void test() {
    Restaurant restaurant = new Restaurant("my restaurant").add(new Menu("a menu"))
                                                           .add(new Menu("another menu"));
    restaurants.add(restaurant);

    Menu menu = restaurants.get(0)
                           .getMenus()
                           .get(0);
}