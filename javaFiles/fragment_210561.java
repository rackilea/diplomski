class MyClass  {

    @JsonProperty("MyClass")
    public List<Map<String,String>> list;

    public static void main(String[] args) throws JsonProcessingException {
        Map<String, String> map1 = new HashMap<String,String>();
        map1.put("key", "value");

        Map<String,String> map2 = new HashMap<String,String>();
        map2.put("key","value");

        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        list.add(map1);
        list.add(map2);

        MyClass d = new MyClass();
        d.list = list;

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(d);
        System.out.println(json);
    }
}