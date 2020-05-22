public class Inventory<T> {
public static ArrayList<Item> inv = new ArrayList<>();
public void addItem (T item){
    inv.add((Item)item); // where item can be anything from Item.item1 to Item.item500
}
public void removeItem (T item){
    inv.remove((Item)item);
}