@Component(modules = {/* ... */})
public interface CoffeeShopComponent {
  CoffeeShop getCoffeeShop();

  void inject(CoffeeService serviceToInject); // to be discussed below
}