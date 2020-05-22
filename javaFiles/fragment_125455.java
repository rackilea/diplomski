@Mapper
public interface UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO map(User user);

    User map(UserDTO userDTO);
}