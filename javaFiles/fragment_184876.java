public class User implements java.io.Serializable {

    // Properties.
    private Long id;
    private String name;
    private Date birthdate;

    // Getters.
    public Long getId() { return id; }
    public String getName() { return name; }
    public Date getBirthdate() { return birthdate; }

    // Setters.
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setBirthdate(Date birthdate) { this.birthdate = birthdate; }

    // Important java.lang.Object overrides.
    public boolean equals(Object other) {
        return (other instanceof User) && (id != null) ? id.equals(((User) other).id) : (other == this);
    }
    public int hashCode() {
        return (id != null) ? (getClass().hashCode() + id.hashCode()) : super.hashCode();
    }
    public String toString() {
        return String.format("User[id=%d,name=%s,birthdate=%d]", id, name, birthdate);
    }
}