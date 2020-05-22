public class Value {
    @SerializedName("serial")
    private String serial;
    @SerializedName("online")
    private String online;
    @SerializedName("menus")
    private Menu[] menus;

    // getters, setters
}
public class Menu {
    @SerializedName("menu_name")
    private String menuName;
    @SerializedName("price")
    private String price;

    // getters, setters
}