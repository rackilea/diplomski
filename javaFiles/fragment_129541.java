interface Pizza {
  int cost();
}

public class PlainPizza implements Pizza {

  @Override
  public int cost() {
    return 10;
  }
}

public abstract class ToppingDecorator implements Pizza {
  private Pizza pizza;

  public ToppingDecorator(PlainPizza aPizza) {
    pizza = aPizza;
  }

  @Override
  public int cost() {
    return pizza.cost();
  }
}

public class SalamiPizza extends ToppingDecorator {
  public SalamiPizza(PlainPizza aPizza) {
    super(aPizza);
  }

  @Override
  public int cost() {
    return super.cost() +3;
  }
}

public static void main(String[] args) {
  SalamiPizza p = new SalamiPizza(new PlainPizza());
  System.out.print(p.cost());
}