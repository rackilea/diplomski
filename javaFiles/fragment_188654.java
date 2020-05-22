@Transactional
public void editUser(int userId, User editUser) {
    User liveUser = getUserDAO().findByPrimaryKey(userId);
    liveUser.setNameFirst(editUser.getNameFirst());
    liveUser.setNameLast(editUser.getNameLast());
    liveUser.setEmail(editUser.getEmail());
    liveUser.setAddress(editUser.getAddress());
}