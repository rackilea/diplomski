public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        byte[] someBytes = "Hello world".getBytes(StandardCharsets.UTF_8);
        DataHolder dataHolder = new DataHolder(someBytes);
        ObjectMapper objectMapper = new ObjectMapper();
        String output = objectMapper.writeValueAsString(dataHolder);
        System.out.println(output);
    }
}