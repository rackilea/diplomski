public static void main(String[] args) throws Exception {

    Foo foo1 = new Foo();
    foo1.setName("foo");
    foo1.setData(new HashMap<String, Object>(){{
        put("date",   new Date());
        put("bool",   true);
        put("string", "yeah");
    }});
    ObjectMapper mapper = new ObjectMapper();
    String jsonStr = mapper.writeValueAsString(foo1);
    System.out.println(jsonStr);
    Foo foo2 = mapper.readValue(jsonStr, Foo.class);

    System.out.println(foo2.equals(foo1));

}