public interface CityRepository extends JpaRepository<City, Long>{

    City findOneByName(String name);
    @Query("SELECT name FROM City")
    public List<City> findMethod1();

    @Query("SELECT c.name FROM City c")
    public List<City> findMethod2();