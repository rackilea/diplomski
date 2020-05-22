public class Test {

    public static void main(String[] args) throws IOException {
        String jsonInString = "{\n"
                + "  \"aud\": \"RoomyClinetApps\",\n"
                + "  \"sub\": \"AAAA\",\n"
                + "  \"user\": {\n"
                + "    \"firtsName\": \"Godavarthi\",\n"
                + "    \"LastName\": \"chaitanya\"\n"
                + "  },\n"
                + "  \"iss\": \"Roomy\",\n"
                + "  \"iat\": 1499279510\n"
                + "}";
        ObjectMapper mapper = new ObjectMapper().configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonObject jobj = mapper.readValue(jsonInString.toString(), JsonObject.class);

        System.out.println(jobj.getUser().getFirtsName());
    }

}

class User {

    private String firtsName;
    private String LastName;

    public String getFirtsName() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

}

class JsonObject {

    private String aud;
    private String sub;
    private User user;
    private String iss;
    private long iat;

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public long getIat() {
        return iat;
    }

    public void setIat(long iat) {
        this.iat = iat;
    }

}