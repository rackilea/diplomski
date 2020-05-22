public class CarTest {

    private EngineType DIESEL = EngineType.DIESEL;

    @Test
    public void testCreate() {
        Car car = createWithSeedValue();
        Assert.equals(DIESEL, car.getEngine().getEngineType());
    }

    public Car createWithSeedValue() {
        return create(EngineTest.createWithSeedValue(DIESEL));
    }

    public Car create(Engine engine) {
        Car car = new Car(engine);
        return car;
    }
}