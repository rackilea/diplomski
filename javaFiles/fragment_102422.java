public class User {
    ...
    public boolean equals(Object other) {
        if (this==other) return true;
        if (id==null) return false;
        if ( !(other instanceof User) ) return false;
        final User that = (User) other;
        return this.id.equals( that.getId() );
    }
    public int hashCode() {
        return id==null ? System.identityHashCode(this) : id.hashCode();
  }
}