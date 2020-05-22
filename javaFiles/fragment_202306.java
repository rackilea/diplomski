public abstract class FoodService {
    protected RecipeService recipeService;

    FoodService (RecipeService recipeService) {
        this.recipeService = recipeService;
    }
}

public class ItalianFoodService extends FoodService {
    // Only needed if ItalianRecipeService holds additional methods.
    @Inject @Italian ItalianRecipeService recipeService;

    @Inject
    ItalianFoodService(@Italian RecipeService recipeService) {
       super(recipeService);
    }
}