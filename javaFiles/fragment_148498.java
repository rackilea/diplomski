import java.util.Scanner;
import java.util.Arrays;
import java.text.NumberFormat;

public class Inventory
{
   private static final int DEFAULT_LENGTH = 5;
   private static final int VERSION = 2;

   private Product[] products;
   private int numProducts;

   public static void main(String[] args)
   {
      Inventory inventory = new Inventory(5);

      inventory.addProduct(new Product("EThe Invisible Man", 0, 8.50));
      inventory.addProduct(new Product("DThe Matrix", 1, 17.99));
      inventory.addProduct(new Product("CSe7en", 7, 12.99));
      inventory.addProduct(new Product("BOceans Eleven", 11, 9.99));
      inventory.addProduct(new Product("AHitch Hikers Guide to the Galaxy", 42, 18.69));

      System.out.println(inventory);
      System.out.println("total value: " + NumberFormat.getCurrencyInstance().format(inventory.getTotalValue()));
   }

   public Inventory()
   {
      this(DEFAULT_LENGTH);
   }

   public Inventory(int size)
   {
      products = new Product[size];

      this.numProducts = 0;
   }

   public void addProduct(Product p)
   {
      products[numProducts++] = p;
   }

   public double getTotalValue()
   {
      double inventoryValue = 0.0;

      for (Product product : products)
      {
         inventoryValue += product.calcInventoryValue();
      }

      return inventoryValue;
   }

   public String toString()
   {
      StringBuilder builder = new StringBuilder(1024);
      String newline = System.getProperty("line.separator");

      if (products.length > 0)
      {
         Arrays.sort(products, new ProductComparator());
         for (Product product : products)
         {
            builder.append(product).append(newline);
         }
      }

      return builder.toString();
   }
}