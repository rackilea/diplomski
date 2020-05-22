@Route("custom-appLayout")
public class CustomAppLayout extends AppLayout {
    public CustomAppLayout(){
            Image img = new Image("https://i.imgur.com/GPpnszs.png", "Vaadin Logo");
            img.setHeight("44px");
            addToNavbar(new DrawerToggle(), img);
            Tabs tabs = new Tabs(new Tab("Home"), new Tab("About"));
            tabs.setOrientation(Tabs.Orientation.VERTICAL);
            addToDrawer(tabs);
            addToNavbar(img);

            Div b = new Div();
            b.setText("Bar");
            b.getStyle().set("margin-left", "auto");
            b.getStyle().set("padding", "15px");
            addToNavbar(b);
    }
}