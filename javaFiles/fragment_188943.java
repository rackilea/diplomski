public class CarHandlerTest {
    static long lastCarId = 5;
    private CarHandler carHandler = new CarHandler();
    private CarService carService = new CarService();
    private CarDao carDao;

    @Test
    public void testFoo() throws Exception {
        carDao = Mockito.mock(CarDao.class);
        carService.setCarDao(carDao);
        carHandler.setCarService(carService);

        Mockito.doAnswer(new Answer<Void>() { //I copy it from your example
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                lastCarId++;
                Car car = (Car) invocationOnMock.getArguments()[0];
                // here car.getUser() returns correct user object
                car.setId(lastCarId);
                Mockito.when(carDao.getById(car.getId())).thenReturn(car);
                return null;
            }
        }).when(carDao).persist(Mockito.any());

        carHandler.foo();
    }
}