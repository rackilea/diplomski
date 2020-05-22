public class Item {
    private String name;
    private int quanity;
    private float price;

    public Item(String name, float price, int quanity) {
        this.name = name;
        this.price = price;
        this.quanity = quanity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", quanity=" + quanity + ", price="
                + price + "]";
    }




}