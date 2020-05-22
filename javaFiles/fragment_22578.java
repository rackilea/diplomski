@Inject
UserTransaction tx;

    //merging and refreshing
    tx.begin();
    User managedUser = em.merge(user);
    em.refresh(managedUser);
    tx.commit();
    user = managedUser;

    //refetching
    tx.begin();
    user = em.find(User.class, user.getId);
    tx.commit();