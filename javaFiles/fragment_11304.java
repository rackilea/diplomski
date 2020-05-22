public class User {
    int id;
    ArrayList<Item> items;

    public User(final int id) {
        this.id = id;
        items = new ArrayList<Item>();
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void add(final Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}



public class Item {
    int id;
    double rating;

    public Item(final int id, final double rating) {
        this.id = id;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(final double rating) {
        this.rating = rating;
    }

}