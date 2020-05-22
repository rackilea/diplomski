class User {
    @Id
    Long Id
    String fistName
    String lastName

    @ManyToMany
    Collection<User> subscriptions
}