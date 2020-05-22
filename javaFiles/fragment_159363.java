@Accessor
public interface UserAccessor {
    @Query("SELECT * FROM user")
    Result<User> getAll();
}

UserAccessor userAccessor = manager.createAccessor(UserAccessor.class);
Result<User> users = userAccessor.getAll();