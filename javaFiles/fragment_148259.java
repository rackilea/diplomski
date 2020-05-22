@Query("select distinct u from Users u " +
        " left join fetch u.groups g "
        " left join fetch g.roles r " +
        "  ... "
        " where u.username = :username")
public Users findRoleByUsername(@Param("username") String username);