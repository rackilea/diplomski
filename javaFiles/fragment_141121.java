class User {
    String name;

    @Nested("status")
    Status status;
}

class Status {
    int code;
}

interface Dao {
    @SqlQuery("SELECT user.*, status.code AS `status_code` FROM user LEFT OUTER JOIN Status USING (status_id)
    @RegisterBeanMapper(User.class)
    List<User> getUsers();
}