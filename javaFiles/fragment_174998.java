@Stateless
public class myEjb
{
    // inject the entityManager  
    @PersistenceContext(unitName = "myPu")
    private EntityManager em;

    public Car findCarById(Long carId)
    {
        Car aCar = (Car) em.find(Car.class, carId);
        return aCar;
    }
}