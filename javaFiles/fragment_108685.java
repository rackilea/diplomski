@Mapper
public class PersonMapper {
    @Mapping(target = "organization", source = "model"
    public abstract Person toEntity(PersonModel model);

    @BeanMaping(ignoreByDefault = true)
    @Mapping(target = "id", source = "organizationId")
    protected abstract Organization toOrganizationEntity(PersonModel model)
}