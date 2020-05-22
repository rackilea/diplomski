public class User {
    private static final Gson gson = new Gson();
    public String name;
    public String password;

    public User(String name, String pwd){
        this.name = name;
        this.password = pwd;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new User(this.name, this.password);
    }

    public static void main(String[] aa){
        JsonSerializer<User> ser = new JsonSerializer<User>() {
            @Override
            public JsonElement serialize(User u, Type t, JsonSerializationContext ctx) {
                try {
                    User clone = (User)u.clone();
                    clone.password = clone.password.replaceAll(".","x");
                    return (gson.toJsonTree(clone, User.class));
                } catch (CloneNotSupportedException e) {
                    //do something if you dont liek clone.
                }
                return gson.toJsonTree(u, User.class);
            }
        };
        Gson g = new GsonBuilder().registerTypeAdapter(User.class, ser).create();
        System.out.println(g.toJson(new User("naishe", "S3cr37")));
    }
}