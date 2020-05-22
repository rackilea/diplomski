class User {
    String name;

    @Nested
    Status status;
}

class Status {
    int code;
}

interface Dao {
    @SqlQuery("SELECT * FROM user LEFT OUTER JOIN Status USING (status_id)
    @RegisterBeanMapper(User.class)
    List<User> getUsers();
}