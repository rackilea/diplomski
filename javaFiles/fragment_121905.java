@Select("SELECT * FROM users")
    @Results({
        @Result(property = "firstName", column = "first_name"),
        @Result(property = "lastName", column = "last_name")
    })
    List<User> findUsers();