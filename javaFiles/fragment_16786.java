import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class Test {

    public static void main(String[] args) {
        // Create a vector of categories
        Collection<Category> categories = new Vector<Category>();
        // Create drinks
        List<String> drinks = Arrays.asList("Soda", "Tea", "Cofee");
        // Add drinks to vector
        categories.add(new Category("Drink", drinks));
        // Create groceries
        List<String> groceries = Arrays.asList("Item1", "Item2", "Item3");
        // Add groceries to vector
        categories.add(new Category("Grocery", groceries));

    }

}

class Category {
    String category;
    List<String> items;
    public Category(String category, List<String> items) {
        if (category == null || items == null) {
            throw new IllegalArgumentException("Category and items cannot be null");
        }
        this.category = category;
        this.items = items;
    }
}