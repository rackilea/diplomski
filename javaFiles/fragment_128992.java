public class JSONWriteExample {
    private static final String FILE_NAME = "jsonArray.json";
    private static final Path FILE_PATH = Paths.get(FILE_NAME);
    private final String type;
    private final int quantity;

    public JSONWriteExample(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public void jsonParse() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        if (Files.notExists(FILE_PATH)) {
            Files.createFile(FILE_PATH);
            objectMapper.writeValue(FILE_PATH.toFile(), createItems(new ArrayList<>()));
        }
        Items items = objectMapper.readValue(FILE_PATH.toFile(), Items.class);
        final List<Item> itemsList = items.getItems();
        objectMapper.writeValue(FILE_PATH.toFile(), createItems(itemsList));
    }

    private Items createItems(List<Item> itemsList) {
        final Item item = new Item();
        item.setType(type);
        item.setQuantity(quantity);
        itemsList.add(item);
        final Items items = new Items();
        items.setItems(itemsList);
        return items;
    }

    public static class Items {
        private List<Item> items;
        // Setters, Getters
    }

    public static class Item {
        private String type;
        private int quantity;
        // Setters, Getters
    }
 }