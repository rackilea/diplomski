public class JacksonProgram {

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonFactory jsonFactory = new JsonFactory();
        JsonParser parser = jsonFactory
                .createJsonParser("{\"name\":\"John\", \"grade\":\"D\"}");
        Employee employee = objectMapper.readValue(parser, Employee.class);
        System.out.println(employee);
    }

}