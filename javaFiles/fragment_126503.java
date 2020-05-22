public interface OrderRepository extends MongoRepository<Order,String> {

// Find MAX Value

Order findTopByOrderByOrderDateDesc();

// Find MIN Value

Order findTopByOrderByOrderDateAsc();

}