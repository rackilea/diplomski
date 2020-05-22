public List<Friend> listFriends(String userName) {
    return (List<Friend>) sessionFactory.getCurrentSession()
        .createCriteria(Friend.class)
        .add(Restrictions.eq("userName", userName) )
        .list();
}