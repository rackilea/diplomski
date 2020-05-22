public class User {
    private String name;
    private Integer id;

    public User(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}