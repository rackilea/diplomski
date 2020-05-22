import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ingredients
{
  private Map<String, Double> aIngredientTypeToCost = new HashMap<>();



  public void put(String theType, Double theCost)
  {
    aIngredientTypeToCost.put(theType, theCost);
  }



  public Set<String> getAllIngredientsType()
  {
    return aIngredientTypeToCost.keySet();
  }

}