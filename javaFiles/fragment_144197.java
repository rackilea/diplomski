@JSONMapper
public class itemInventory {

    public static itemInventory_MapperImpl MAPPER = new itemInventory_MapperImpl();

    private static final List<item> itemList = new ArrayList<>();
    @JsonIgnore
    private callbackRun responseHandler = null;

    / * other variables, getters setters here */

}