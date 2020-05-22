@Test
public static void testFilterOutEverythingExceptSportCars() {
    List<Car> cars = ...;
    List<Car> actual = filterOutEverythingExceptSportCars(cars);
    List<Car> expected = ...;
    assertEquals(expected, actual);
}