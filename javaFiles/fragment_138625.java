List<String> items = new ArrayList() {
    {
        add("a");
        add("s");
    }
};
ObjectMapper gson = new ObjectMapper();
String json = gson.writeValueAsString(items);
System.out.println(json);