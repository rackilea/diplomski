public User findById(int id, boolean prefetch) {
    User entity = em.find(User.class, id);
    if (prefetch) {
        // Will trigger 1 or size JDBC calls depending on your fetching strategy
        entity.getOauthLogins().size() 
    }
    return entity;
}