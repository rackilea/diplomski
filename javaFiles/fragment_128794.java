class App {

    static class Response {
        String lastname;
    }

    public static void main(String[] args) {
        String myJsonString = "{\"name\":\"john\",\"lastname\":\"smith\"}";
        Response r = new Gson().fromJson(myJsonString, Response.class);
        System.out.println(r.lastname);
    }
}