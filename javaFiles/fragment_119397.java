@Mapper
public interface UserMinimalMapper {

    UserMinimalMapper INSTANCE = Mappers.getMapper(UserMinimalMapper.class) ;

    UserMinimalDto entityToDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "links", ignore = true)
    User dtoToEntity(UserMinimalDto userMinimalDto);
}