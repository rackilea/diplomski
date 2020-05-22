public class OrderRepository {
  public Foo getById(int id) {
     // 
  }

  public Foo getByCustomer(Customer customer) {
    //
  }
}

public class CustomerRepository {
  public Foo getById(int id) {
     // 
  }

  public Foo getByUserName(string userName) {
    //
  }
}

public class TradingService {
  private OrderRepository _orderRepository;
  private CustomerRepository _customerRepository;

  public TradingService(OrderRepositoryInterface orderRep, CustomerRepositoryInterface cusRep) {
    _orderRepository = orderRep;
    _customerRepository = custRep;
  }

  public void placeOrder(string customerUserName, Order order) {
    Customer customer = _customerRepository.getByUserName(customerUserName);
    order.setCustomer(customer);
    _orderRepository.add(order);
    // ....
  }
}