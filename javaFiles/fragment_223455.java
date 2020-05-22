@Entity
@Table(name = "restaurants")
@NamedEntityGraphs({
    @NamedEntityGraph(name="Restaurant.allJoins", includeAllAttributes = true),
    @NamedEntityGraph(name="Restaurant.noJoins")
})
public class Restaurant extends AbstractNamedEntity implements Serializable {

}

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

    @EntityGraph(value = "Restaurant.allJoins", type = EntityGraphType.FETCH)
    @Override
    List<Restaurant> findAll();

    @EntityGraph(value = "Restaurant.noJoins", type = EntityGraphType.FETCH)
    @Override
    Optional<Restaurant> findById(Integer id);

}