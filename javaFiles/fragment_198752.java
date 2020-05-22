// wrapper class
public class UniqueItem {
    ItemStack item;
    private String uid="";
    public UniqueItem(ItemStack item) {
        this.item = item;
        uid=UUID.randomUUID().toString();
    }

    public String getUniqueID(){
        return uid;
    }
}