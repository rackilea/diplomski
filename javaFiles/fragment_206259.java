public class Users {
    @OneToMany(fetch=FetchType.LAZY, mappedBy="users")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public Set<Sessions> getSessionses() {
        return this.sessionses;
    }
}