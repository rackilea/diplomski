@Mapper
public abstract class UserViewMapper {

    @Mapping(source = "first_name", target = "user.firstName"),
    @Mapping(source = "last_name", target = "user.lastName"),
    public abstract UserView userAndAddressToView(User user, Address address);
}