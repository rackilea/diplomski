@Repository
public interface CityRepository extends JpaRepository<City, Long> {

List<City> findByCountryName(String name);
Page<City> findByCountryName(String name, Pageable pageable);
List<City> findByCountryId(long id);

}