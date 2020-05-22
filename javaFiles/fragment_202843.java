public interface StockProvider {
  Stock createStock(String value);
}

public class MyStockProvider implements StockProvider {
  private final String valueTwo;

  public MyStockProvider(String valueTwo) {
    this.valueTwo = valueTwo;
  }

  @Override
  public Stock createStock(String valueOne) {
    return new MyStock(valueOne, valueTwo);
  }
}

public class MyOtherClass {
  public void analyzeNewStock(StockProvider provider) {
    provider.createStock("Hi!").analyze();
  }

  public static void main(String[] args) {
    analyzeNewStock(new MyStockProvider("Hey!"));
  }
}