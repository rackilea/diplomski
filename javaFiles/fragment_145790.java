public class JacksonDetectError {
    public static final String SUCCESS_JSON = "{  \n" +
            "   \"user_id\":\"542d5f15e4b090c7c78c5938\",\n" +
            "   \"email\":\"test@gmail.com\" \n" +
            "}";

    public static final String ERROR_JSON = "{  \n" +
            "   \"code\":40405,\n" +
            "   \"message\":\"Email not found\"\n" +
            "}";

    public static class Email {
        @JsonProperty("user_id")
        public String userId;
        public String email;

        @Override
        public String toString() {
            return "Email{" +
                    "userId='" + userId + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }

    public static class Error {
        public int code;
        public String message;

        @Override
        public String toString() {
            return "Error{" +
                    "code=" + code +
                    ", message='" + message + '\'' +
                    '}';
        }
    }

    private static Object readJson(String jsonString) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode json = mapper.readTree(jsonString);
        if (json.has("code")) {
            return mapper.readValue(json.traverse(), Error.class);
        }
        return mapper.convertValue(json, Email.class);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readJson(ERROR_JSON));
        System.out.println(readJson(SUCCESS_JSON));
    }
}