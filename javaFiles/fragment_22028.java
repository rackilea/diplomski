public void saveUser(User user) {
    try {
        userDao.saveUser(user);
    } catch(DuplicateKeyException e) {
        throw new UserException("User already exist");
    } catch(DataAccessException e) {
        throw new UserException("Databae unreachable");
    }
}