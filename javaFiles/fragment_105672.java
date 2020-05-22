public class Response {

        @SerializedName("users")
        private List<Users> users;
        private String next_cursor;
        private String previous_cursor_str;
        private String previous_cursor;
        private String next_cursor_str;
    }