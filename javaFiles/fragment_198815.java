public class Menu implements Cloneable {

    final int MAX_ITEMS = 50;
    private MenuItem[] menu;

    public Menu(){
        menu =  new MenuItem[MAX_ITEMS];
    }
}