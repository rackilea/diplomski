public void updateUser(long userId, User updatedUser) {
    User currentUser = dao.getCurrentUserById(userId);
    currentUser.userName = updatedUser.username;
    //...... update anyother fields....
    dao.SaveUser(currentUser);
}