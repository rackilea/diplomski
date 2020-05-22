@Mapper
@Named("RoleBaseMapper")
public interface RoleBaseMapper {

    @Mapping(target = "code", source = "name")
    @Named("mapToBase")
    RoleGuiBaseDto mapToBase(Role role);

    @IterableMapping(qualifiedByName = "mapToBase")
    @Named("MapListToBase")
    List<RoleGuiBaseDto> mapListToBase(List<Role> roles);
}