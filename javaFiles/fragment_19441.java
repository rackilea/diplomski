import java.util.Collection;
import java.util.Comparator;

interface Pizza {
    interface Ingredient {
        boolean isMeat();

        int getPrice();
    }

    Collection<Ingredient> getIngredients();

    static boolean isVegetarian(Pizza pizza) {
        return pizza.getIngredients().stream().noneMatch(Ingredient::isMeat);
    }

    static int price(Pizza pizza) {
        return pizza.getIngredients().stream().mapToInt(Ingredient::getPrice).sum();
    }

    static Pizza mostExpensiveVegetarianPizza(Collection<Pizza> pizzas) {
        return pizzas.stream()
                     .filter(Pizza::isVegetarian)
                     .max(Comparator.comparingInt(Pizza::price))
                     .orElseThrow(() -> new IllegalArgumentException("no veggie pizzas"));
    }
}