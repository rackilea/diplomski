override fun findSomeUsers(batchSize: Int): Flow<User> {
    return em.createQuery("select u from User u where ...")
            .setHint(HINT_FETCH_SIZE, batchSize) // "org.hibernate.fetchSize"
            .unwrap(javax.persistence.Query::class.java)
            .resultStream
            .asFlow()
            .map { it as User }
}