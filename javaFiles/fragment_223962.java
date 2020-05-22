public class GsonTest {
    public static void main(String[] args) {
        String json = "[\n" +
                "  {\"id\":1, \"type\":\"zombie\", \"name\":\"Ugly Tom\", \"uglyness\":42},\n" +
                "  {\"id\":2, \"type\":\"hunter\", \"name\":\"Shoot in leg Joe\", \"skill\":0}\n" +
                "]";

        Gson gson = new GsonBuilder().registerTypeAdapter(Person.class, new PersonJsonDeserializer()).create();

        Type type = new TypeToken<List<Person>>(){}.getType();

        List<Person> list = gson.fromJson(json, type);

        for(Person p : list) {
            System.out.println(p);
        }
    }
}