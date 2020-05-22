User user = entityManager.createQuery(
    "select u from User u where id = :id", User.class)
.setParameter("id", id);
.unwrap( Query.class )
.setLockOptions(
    new LockOptions( LockMode.PESSIMISTIC_WRITE )
        .setFollowOnLocking( false ) )
.getSingleResult();