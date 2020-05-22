public class User {

    private Long id;

    @Override
    public boolean equals(Object object) {
        return (object instanceof User) && (id != null) 
             ? id.equals(((User) object).id) 
             : (object == this);
    }

    @Override
    public int hashCode() {
        return (id != null)
             ? (User.class.hashCode() + id.hashCode())
             : super.hashCode();
    }

}