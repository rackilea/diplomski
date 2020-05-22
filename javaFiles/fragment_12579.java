public List<Friend> listFriends(String userName) {
    Friend friend = new Friend();
    friend.setUserName(userName);

    return (List<Friend>) sessionFactory.getCurrentSession()
        .createCriteria(Friend.class)
        .add(Example.create(friend))
        .list();
}