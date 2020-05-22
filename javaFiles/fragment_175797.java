@SerializableAs("Inventory")
public class SInventory implements ConfigurationSerializable {

    private final List<ItemStack> items = new ArrayList<>();
    private ItemStack head;
    private ItemStack chest;
    private ItemStack legs;
    private ItemStack boots;

    /* Other fields */

    public SInventory(Map<String, Object> config) {
        List<ItemStack> items = (List<ItemStack>) config.get("inventory");
        for (ItemStack item : items) {
            if (item != null) {
                this.items.add(item);
            }
        }
        this.head = (ItemStack) config.get("head");
        this.chest = (ItemStack) config.get("chest");
        this.legs = (ItemStack) config.get("legs");
        this.boots = (ItemStack) config.get("boots");
    }

    public static SInventory valueOf(Map<String, Object> config) {
        return new SInventory(config);
    }

    public static SInventory deserialize(Map<String, Object> config) {
        return new SInventory(config);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> back = new HashMap<>();
        back.put("inventory", this.items);
        back.put("head", this.head);
        back.put("chest", this.chest);
        back.put("legs", this.legs);
        back.put("boots", this.boots);
        return back;
    }