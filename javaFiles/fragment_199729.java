import java.util.ArrayList;

abstract class CheckList<T extends ListItem> {
    String name;
    ArrayList<T> items;

    String getName() { return this.name; }
    ArrayList<T> getItems() { return this.items; }

    public String setName(String name) { return this.name = name; }

    public abstract void addItem(String name);

    public boolean editItem(String oldName, String newName) {
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).getName().equals(oldName)) {
                items.get(i).setName(newName);
                return true; // target found
            }
        }
        return false; // cannot find the target
    }

    public boolean deleteItem(String name) {
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).getName().equals(name)) {
                items.remove(i);
                return true; // target found
            }
        }
        return false; // cannot find the target
    }

    public boolean completeItem(String name) {
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).getName().equals(name)) {
                items.get(i).setCompleted(true);
                return true; // target found
            }
        }
        return false; // cannot find the target
    }
}

class ListItem {
    private String name;
    private Boolean completed;

    public String getName() {
        return name;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}

class ShoppingListItem extends ListItem {
    public ShoppingListItem(String name) {
        this.setName(name);
    }
}
public class ShoppingList extends CheckList<ShoppingListItem> {

    public ShoppingList (String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void addItem(String name) {
        // add a new ShoppingListItem to items
        final ShoppingListItem item = new ShoppingListItem(name);
        this.items.add(item);
    }
}