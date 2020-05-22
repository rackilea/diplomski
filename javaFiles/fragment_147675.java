public class CustomerDatabase implements Database<Customer> {

  @Override
  public void store(Class<? extends Customer> clazz, Customer x) {
    ...
  }

  ...

}