public static void main(String... args) {
  City berlin = new City("Berlin");
  City beijing = new City("Beijing");

  //fill the connections here

  ArrayList<City> route = new ArrayList<City>();

  boolean success = determineRoute(berlin, beijing, route);
}