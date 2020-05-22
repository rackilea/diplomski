public class GroceryList {

    private GroceryItemOrder[] list = null;

    public GroceryList() {
        list = new GroceryItemOrder[10];
    }

    public void add(GroceryItemOrder item) {
        for(int i=0; i<list.length; i++) {
            if(list[i] == null) {
                list[i] = item;
                System.out.println(item);
                break;
            }
        }
    }
}