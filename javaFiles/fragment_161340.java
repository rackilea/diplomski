public class User {

    private String id;
    private final String personId;

    public User(String id, String personId) {
        this.id = id;
        this.personId = personId;
    }

    public User(String personId) {
        this.personId = personId;
    }

    public String getPersonId() {
        return personId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}