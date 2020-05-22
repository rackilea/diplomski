public List<Tweet> findAllForSubscriber(TwitterUser user) {
    // Select tweets
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Tweet> cq = cb.createQuery(Tweet.class);
    Root<Tweet> tweet = cq.from(Tweet.class);
    cq.select(Tweet);

    // Select subscribers of user
    Subquery<Long> sq = cq.subquery(Long.class);
    Root<TwitterUser> twitterUser = sq.from(TwitterUser.class);
    Join<TwitterUser, TwitterUser> subscriptions = twitterUser.join(TwitterUser_.subscriptions);
    sq.select(subscriptions.get(TwitterUser_.id));
    sq.where(cb.equal(twitterUser, user));

    // Where authorId in list of subscribers
    cq.where(cb.in(tweet.get(Tweet_.author).get(TwitterUser_.id)).value(sq));

    //
    return em.createQuery(cq).getResultList();
}