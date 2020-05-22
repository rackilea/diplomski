import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class pizza
{

  public static void main(String args[])
  {
    Map<String, Ingredients> aMap = new HashMap<>();

    Ingredients aHawaiPizza = new Ingredients();
    aHawaiPizza.put("Salami", 3.50);
    aHawaiPizza.put("Cheeze", 1.50);

    aMap.put("Hawai", aHawaiPizza);

    Ingredients aXyzPizza = new Ingredients();
    aXyzPizza.put("Pickles", 0.50);
    aXyzPizza.put("Thuna", 2.50);

    aMap.put("aXyzPizza", aXyzPizza);

    for( Entry<String, Ingredients> aType : aMap.entrySet() )
    {
      String aPizza = aType.getKey();
      Ingredients aIngredients = aType.getValue();

      System.out.println("A pizza " + aPizza + " has ingredients " + aIngredients.getAllIngredientsType());
    }

  }
}