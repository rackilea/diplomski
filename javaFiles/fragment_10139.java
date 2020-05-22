public class ResponseData {
    private Response response;
    // +getter+setter

    public static class Response {
        private int reference;
        private Data data;
        // +getters+setters
    }

    public static class Data {
        private User user;
        // +getter+setter
    }

    public static class User {
        private String id;
        private String firstName; 
        private String lastName;
        private String email;
        private String phone;
        private Linkedid linkedid;
        // +getters+setters
    }

    public static class Linkedid {
        private String id;
        // +getter+setter
    }
}