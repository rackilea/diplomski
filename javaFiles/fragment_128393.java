@Entity
@Table(name="orders")
class Order {
@Id @GeneratedId private Long id;
@OneToMany(mappedBy="order")
private List<Item> items;

public Order() {
items = new ArrayList<Item>();
}

public void addItem(Item item) {
if (item != null)
items.add(item);
}
    /* getters setters */