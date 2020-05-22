@Override
public UserDetail getUserByUserName(String userName) throws MyException {
    try {
        Session session = sessionFactory.getCurrentSession();
        return (UserDetail) session.createCriteria(UserDetail.class).add(Restrictions.eq("userName", userName))
                .uniqueResult();

    } catch (Exception e) {
        throw new MyException(e.getMessage());
    }
}