@Mapper
interface PersonMapper {
    @Mapping(target = "organization", source = "model"
    Person toEntity(PersonModel model);

    @BeanMaping(ignoreByDefault = true)
    @Mapping(target = "id", source = "organizationId")
    Organization toOrganizationEntity(PersonModel model)
}