public class User {
    ...
    public boolean equals(Object other) {
        if (this==other) return true;
        if ( !(other instanceof User) ) return false;
        final User that = (User) other;
        return this.username.equals( that.getUsername() );
    }
    public int hashCode() {
        return username.hashCode();
  }
}