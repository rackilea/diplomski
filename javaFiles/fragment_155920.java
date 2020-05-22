import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class CocktailTest {

    @Test
    public void addOneIngredient() {
        Cocktail cocktail = new Cocktail();
        cocktail.addIngredient("whiskey", 5);

        assertThat(cocktail.root.toString(), is("{\"ingredients\":[{\"amount\":5,\"name\":\"whiskey\"}]}"));

    }
    @Test
    public void addTwoIngredients() {
        Cocktail cocktail = new Cocktail();
        cocktail.addIngredient("whiskey", 5);
        cocktail.addIngredient("olive", 2);

        assertThat(cocktail.root.toString(), is("{\"ingredients\":[{\"amount\":5,\"name\":\"whiskey\"},{\"amount\":2,\"name\":\"olive\"}]}"));
    }

    @Test
    public void getOneIngredient() {
        Cocktail cocktail = new Cocktail();
        cocktail.addIngredient("whiskey", 5);
        JSONObject ingredient = cocktail.getIngredient("whiskey");

        assertThat(ingredient.get("name"), is("whiskey"));
        assertThat(ingredient.get("amount"), is(5));
    }

    @Test
    public void getAllIngredients() {
        Cocktail cocktail = new Cocktail();
        cocktail.addIngredient("whiskey", 5);
        cocktail.addIngredient("olive", 2);
        JSONArray ingredients = cocktail.getIngredients();

        JSONObject whiskey = ingredients.getJSONObject(0);
        assertThat(whiskey.get("name"), is("whiskey"));
        assertThat(whiskey.get("amount"), is(5));

        JSONObject olive = ingredients.getJSONObject(1);
        assertThat(olive.get("name"), is("olive"));
        assertThat(olive.get("amount"), is(2));
    }
}