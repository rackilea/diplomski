public User updateUser(User user) {

    try {
        User result = session.get(User.class, user.getId());
        if (result == null) {
            throw new FilamentNoSuchRecordException(new CoreError(304, "User does not exist"));
        }
        result.setName(user.getName()); // update some properties
        session.update(result); // you should update 'result', not 'user'

        return result;
    } catch (HibernateException e) {
        e.printStackTrace();
        throw new FilamentDataConnectivityException(new CoreError(305,"Connectivity issue. Please see System Administrator"));
    }

}