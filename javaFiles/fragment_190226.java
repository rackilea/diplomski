public class JacksonJsonFormat {
    public static class Bean {
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        public Date getTime() {
            return new Date();
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(new Bean()));
    }
}