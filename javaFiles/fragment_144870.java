public class User {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

public String getData (@RequestBody User user) {
    Long id_long = user.getId();