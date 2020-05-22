public class JsonCommonTest {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String data = "{\"items\": [{\"link\": \"address1\"},{\"link\": \"address2 \"}]}";
        Result result = mapper.readValue(data, Result.class);
        System.out.println(result.items.size());
    }
}