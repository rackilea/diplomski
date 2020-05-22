@Entity
private class User {

    /**
     * requests made to this user, in order for this user to be a host
     */
    @OneToMany(mappedBy = "host")
    private Set<Request> hostRequests = new HashSet<>();

    /**
     * requests made by this user, in order for this user to be a visitor
     */
    @OneToMany(mappedBy = "visitor")
    private Set<Request> visitorRequests = new HashSet<>();

    // ...
}