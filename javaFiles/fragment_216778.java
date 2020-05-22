// Builder Pattern
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        private NutritionFacts state = new NutritionFacts(0,0,0,0,0,0);

        public Builder servingSize(int val) { 
            state = new NutritionFacts(val, state.servings, state.calories, state.fat, state.sodium, state.carbohydrate);
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

    private NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize  = servingSize;
        this.servings     = servings;
        this.calories     = calories;
        this.fat          = fat;
        this.sodium       = sodium;
        this.carbohydrate = carbohydrate;
    }
}