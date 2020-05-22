public void sendFriendRequest(FriendStatus status) {

    User requester=userDao.findOne(status.getRequestAcceptor.getId());
    User sender=userDao.findOne(status.getRequestSender.getId());
    ......
    statusDao.create(status);
    status.getRequestAcceptor(requester);
    status.getRequestSender(sender);
    statusDao.update(status);

}