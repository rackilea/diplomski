@MapperConfig(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG)
public interface CommonMappingConfig {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "links", ignore = true)
    BaseEntity map(ResourceSupport resourceSupport);

}

@Mapper(config = CommonMappingConfig.class)
public interface UserMinimalMapper {

    UserMinimalMapper INSTANCE = Mappers.getMapper(UserMinimalMapper.class) ;

    UserMinimalDto entityToDto(User user);

    User dtoToEntity(UserMinimalDto userMinimalDto);
}