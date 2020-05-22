public class Item {

    private String name;
    private String age;

    //methods
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}

public class CollectionOfItems {

    List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }
}