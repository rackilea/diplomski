public class Menu implements Cloneable {

    final int MAX_ITEMS = 50;
    private MenuItem[] menu;

    public Menu(){
        menu =  new MenuItem[MAX_ITEMS];
    }

    public Menu cloneOne(){
        Menu a = new Menu();
        a.menu = menu;
        return a;
    }

    public Menu cloneTwo(){
        Menu a = new Menu();
        a.menu = new MenuItem[menu.length];
        for(int i = 0; i < menu.length; i++)
            a.menu[i] = menu[i];
        return a;
}