import org.json.JSONArray;
import org.json.JSONObject;

public class Cocktail {
    public final JSONObject root = new JSONObject();

    public Cocktail() {
       root.put("ingredients", new JSONArray()) ;
    }

    public void addIngredient(String ingredientName, int amount) {

        JSONObject ingredient = new JSONObject();
        ingredient.put("name", ingredientName);
        ingredient.put("amount", amount);
        JSONArray ingredients = (JSONArray) root.get("ingredients");
        ingredients.put(ingredient);
    }

    public JSONObject getIngredient(String ingredientName) {
        JSONArray ingredients = (JSONArray) root.get("ingredients");
        for (Object ingredientObj: ingredients ) {
            JSONObject ingredient = (JSONObject)ingredientObj;
            if (ingredient.get("name").equals(ingredientName)) {
                return ingredient;
            }
        }

        throw new IllegalArgumentException("Couldn't find " + ingredientName);
    }

    public JSONArray getIngredients() {
        return root.getJSONArray("ingredients");
    }
}