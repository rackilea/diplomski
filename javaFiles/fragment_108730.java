public interface RestaurantCommercialDao extends Dao<RestaurantCommercial> {

}

public class HibernateRestaurantCommercialDao extends CommonHibernateDao<RestaurantCommercial> implements RestaurantCommercialDao {

    public HibernateRestaurantCommercialDao() {
        super(RestaurantCommercial.class);
    }
}