import org.springframework.data.geo.Point;
import org.springframework.data.neo4j.conversion.PointConverter;

public interface RestaurantRepository extends Neo4jRepository<Restaurant, Long> {

    List<Restaurant> findByNameAndLocationNear(String name, Distance distance, Point point);

    List<Restaurant> findByLocationNearAndName(Distance distance, Point point, String name);
}