PreparedStatement stmt = null;
ResultSet rset = null;

try {

    StringBuilder sql = new StringBuilder(1024);
    sql.append("select ");
    sql.append(session.buildSelect(User.class));
    sql.append(" from Users");
    sql.append(" where gender = ? and (city_id = ? or city_id = ?)");

    stmt = prepare(conn, sql.toString(), Gender.MALE.getId(), 235, 236); // varargs for params (from SQLUtils)

    rset = stmt.executeQuery();

    List<User> users = new LinkedList<User>();

    while(rset.next()) {
        User u = new User();
        session.populateBean(rset, u);
        users.add(u);
    }

    System.out.println("Number of users loaded: " + users.size());

} finally {
    close(rset, stmt, conn); // from SQLUtils
}