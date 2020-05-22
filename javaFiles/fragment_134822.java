public class Question42529415 {

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            //.serializeNulls()
            .create();

    private static Item fromPost(String postRequestJson) {
        return GSON.fromJson(postRequestJson, Item.class);
    }

    private static String toClient(Item item) {
        return GSON.toJson(item);
    }

    public static void main(String[] args) {
        String clientReq = "{\n"
                + "    \"id\": 1,\n"
                + "    \"name\": \"A green door\",\n"
                + "    \"price\": 12.50,\n"
                + "    \"tags\": [\"home\", \"green\"]\n"
                + "}";

        Item item = fromPost(clientReq);
        System.out.println(item.getName() + " " + item.getOption());

        item.setOption("modified option");
        String modified = toClient(item);
        System.out.println(modified);
    }
}

class Item {
    private String id;
    private String name;
    private String option;
    private double price;
    private List<String> tags;

    // getters and setters
}