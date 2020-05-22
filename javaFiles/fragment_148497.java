import java.util.Scanner;
import java.util.Arrays;

public class InventoryPart2
{
   public static void main(String[] args)
   {
      final int ARRAY_LENGTH = 5;
      final int version = 2;

      int counter = 0;

      Product productArray[] = new Product[ARRAY_LENGTH];

      System.out.printf("\n%s%d\n",
      "Welcome to the Productentory Program v.", version);

      productArray[0] = new Product("EThe Invisible Man", 0, 8.50);
      productArray[1] = new Product("DThe Matrix", 1, 17.99);
      productArray[2] = new Product("CSe7en", 7, 12.99);
      productArray[3] = new Product("BOceans Eleven", 11, 9.99);
      productArray[4] = new Product("AHitch Hikers Guide to the Galaxy", 42, 18.69);

      productArray = sortProductArray(productArray);

      // Print sorted array
      for (Product product : productArray)
      {
         if (counter == 0)
         {
            System.out.printf("\n%s\n", "Sorted Inventory of DVD movies");
         }
         System.out.printf("\n\n%s%d\n%s%s\n%s%d\n%s%.2f\n%s%.2f\n",
         "Item Number:      ", counter,
         "DVD Title:        ", product.getProductTitle(),
         "Copies in stock:  ", product.getUnitsInStock(),
         "Price each disk:  $", product.getUnitPrice(),
         "Value of disks:  $", product.calcInventoryValue());
         counter++;
      }
      System.out.printf("\n%s%,.2f\n\n\n",
      "Collection Value: $", calcTotalInventoryValue(productArray));
   }

   private static double calcTotalInventoryValue(Product[] productArray)
   {
      double inventoryValue = 0;

      for (Product product : productArray)
      {
         inventoryValue += product.calcInventoryValue();
      }

      return inventoryValue;

   }

   private static Product[] sortProductArray(Product[] productArray)
   {
      Arrays.sort(productArray, new ProductComparator());

      return productArray;
   }
}