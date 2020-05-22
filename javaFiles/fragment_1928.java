public class Foo {

@Autowire
private CustomerRepository repo;

  public void storeCustomer(String firstName, String lastName) {
  this.repo.save(new Customer(firstName, lastName));
  } 
}