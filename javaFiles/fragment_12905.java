public static UserRole[] getUserRoleList(String order, Boolean reverseOrder) throws SQLException {
    Session session = openSession();
    List<UserRole> list;

    if (!reverseOrder) {
        // obtain list and sort by provided field in ascending order
        list = session.createCriteria(UserRole.class).addOrder(Order.asc(order)).list();
    } else {
        // sort descending
        list = session.createCriteria(UserRole.class).addOrder(Order.desc(order)).list();
    }

    // return UserRole[]
    return list.toArray((UserRole[]) Array.newInstance(UserRole.class, list.size()));
}