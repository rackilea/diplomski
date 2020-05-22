public abstract class FoodService {
    protected RecipeService recipeService;
}

public class ItalianFoodService extends FoodService {
    // Only needed if ItalianRecipeService holds additional methods.
    @Inject @Italian ItalianRecipeService recipeService;

    @PostConstruct
    postConstruct() {
       super.recipeService = recipeService;
    }
}