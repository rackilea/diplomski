public class App {
    public static void main(String[] args) throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();

        System.out.println(objectMapper.readValue(App.class.getResourceAsStream("/data.json"), Data.class));
        System.out.println(objectMapper.readTree(App.class.getResourceAsStream("/data.json")));
    }
}