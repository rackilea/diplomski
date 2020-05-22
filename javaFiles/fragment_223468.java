public static void main(String[] args) throws FileNotFoundException {
    Gson gson = new Gson();
    String json = readFromFile(new File("json.txt"));
    HashMap<String, GObj> maps = gson.fromJson(json, new TypeToken<HashMap<String, GObj>>(){}.getType());
    System.out.println(maps.get("16").description);
}

static String readFromFile(File file) throws FileNotFoundException {
    Scanner scanner = new Scanner(new FileInputStream(file));
    StringBuilder builder = new StringBuilder();
    while (scanner.hasNext()) {
        builder.append(scanner.nextLine());
    }
    scanner.close();
    return builder.toString();
}

static class GObj {
    public int    entity_id;
    public int    attribute_set_id;
    public int    status;
    public int    tax_class_id;
    public int    color;
    public int    visibility;
    public int    manufacturer;
    public double weight;
    public double price;
    public double cost;
    public String type_id;
    public String sku;
    public String model;
    public String dimension;
    public String description;
    public String in_depth;
    public String activation_information;
    public String meta_keyword;
    public String short_description;
    public String custom_layout_update;
    public String name;
    public String url_key;
    public String meta_title;
    public String meta_description;
    public String gift_message_available;
    public String options_container;
    public String custom_design;
}