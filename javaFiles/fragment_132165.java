public UserActivityStat getUserActivityStat(User user) {
     return (UserActivityStat) hibernateSession.createQuery(
             "select count(*) as totalPhotos, sum(p.views) as totalViews " +
             "from Photo p " + 
             "where p.user = :user " +
             "p.dateCreated  <= :now")
         .setParameter("user", user)
         .setTimestamp("now", new Date())
         .setResultTransformer(Transformers.aliasToBean(UserActivityStat.class))
         .uniqueResult();
}