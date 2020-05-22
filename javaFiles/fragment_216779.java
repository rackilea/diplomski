// Builder Pattern
public class NutritionFacts {
    private int servingSize = 0;
    private int servings = 0;
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;

    public static class Builder {
        private NutritionFacts state = new NutritionFacts();

        public Builder servingSize(int val) { 
            state.servingSize = val;
            return this;
        }
        public Builder servings(int val) { 
            state.servings = val;
            return this;
        }
        [...]

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize  = builder.state.servingSize;
        servings     = builder.state.servings;
        calories     = builder.state.calories;
        fat          = builder.state.fat;
        sodium       = builder.state.sodium;
        carbohydrate = builder.state.carbohydrate;
    }
}