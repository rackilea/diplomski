@ManagedBean
@ViewScoped
public class NewDishBean {

    public class Dish {

        private String preparation;

        private List<Ingredient> ingredients = new ArrayList<Ingredient>();

        public List<Ingredient> getIngredients() {
            return ingredients;
        }

        public String getPreparation() {
            return preparation;
        }

        public void setIngredients(List<Ingredient> ingredients) {
            this.ingredients = ingredients;
        }

        public void setPreparation(String preparation) {
            this.preparation = preparation;
        }

        @Override
        public String toString() {
            return "Dish [preparation=" + preparation + ", ingredients="
                    + ingredients + "]";
        }

    }

    public class Ingredient {

        private Dish dish;

        private int amount;

        private String unit;

        private String name;

        public int getAmount() {
            return amount;
        }

        public Dish getDish() {
            return dish;
        }

        public String getName() {
            return name;
        }

        public String getUnit() {
            return unit;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public void setDish(Dish dish) {
            this.dish = dish;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        @Override
        public String toString() {
            return "Ingredient [amount=" + amount + ", unit=" + unit
                    + ", name=" + name + "]";
        }
    }

    private Dish newDish = new Dish();

    public void addIngredient() {
        Ingredient i = new Ingredient();
        i.setDish(newDish);
        newDish.ingredients.add(i);
    }

    public void createDish() {
        // Do your JPA stuff
        System.out.println(newDish + " created!");
    }

    public Dish getNewDish() {
        return newDish;
    }

    public void removeIngredient() {
        if (!newDish.ingredients.isEmpty()) {
            newDish.ingredients.remove(newDish.ingredients.size() - 1);
        }
    }

}