public class GsonSendToSinatra {

    private static class Session {
        @SuppressWarnings("unused")
        String username, password;
    }

    public static void main(String[] args) throws Exception {
        Session session = new Session();
        session.username = "foo@example.com";
        session.password = "qwerty1234";

        Gson gson = new Gson();

        String responseText = Request.Post("http://localhost:4567/echo")
            .bodyString(gson.toJson(session), ContentType.APPLICATION_JSON)
            .execute()
            .returnContent()
            .asString();

        System.out.println(responseText);
    }
}