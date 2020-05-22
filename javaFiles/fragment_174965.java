import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Discount {

  public void printAllContent(List<Item> items) {
      items.forEach(item -> System.out.printf("name = %s, price = %.00f \n", item.getName(), item.getPrice()));
  }

  public static void main(String[] args) {
    Discount card = new Discount();

    List<Item> items = Arrays.asList(
        new Food(3.0, "burgers"), new Food(9.0, "tomato"), new Food(8.0, "fries"),
        new Bevarage(9.0, "cola"), new Bevarage(12.0, "water"), new Food(2.0, "beer")
    );


    card.printAllContent(items);
    for (Item item : items) {
      item.discount(1.0);
    }

    card.printAllContent(items);
    // if you want to do different discounts for different items
    for(Item item: items) {
      if (item instanceof Bevarage) {
        item.discount(2.0);
      } else {
        item.discount(1.0);
      }
    }
    card.printAllContent(items);
  }
}