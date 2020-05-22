public class User {

    private String name;
    private Date birth;
    private int housenumber;
    private long phonenumber;

    @Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof User)) return false;

        // Property checks.
        User other = (User) object;
        return Objects.equals(name, other.name)
            && Objects.equals(birth, other.birth)
            && (housenumber == other.housenumber)
            && (phonenumber == other.phonenumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birth, housenumber, phonenumber);
    }

}