public static void deleteUser(userName)
throws Exception
{
    PreparedStatement ps;

    new DBFacade().connect();
    // (Assuming 'c' is a connection that's in scope somehow)
    synchronized (c) {
        // (You'd want to cache the prepared statement in an appropriate
        // way related to how you're handling connections and pooling)
        ps = c.prepareStatement("delete from users where name = ?");
        ps.setString(1, userName);
        ps.executeUpdate();
    }
}