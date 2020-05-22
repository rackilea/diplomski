@RunWith(SpringRunner.class)
@DataJpaTest(showSql= true)
public class CarRepositoryTest
{
    @Autowire
    private CarRepository repo;

    @Test
    public  void saveTest() throws Exception {

        Car car = new Car(1L, "MyFirstCar");
        Car saved =  repo.save(car);

        assertNotNull(saved);
    }
}