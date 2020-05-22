@Mapper(componentModel = "spring")
interface Mapper {

    @Mappings({
            @Mapping(source = "street", target = "address.street"),
            @Mapping(source = "city", target = "address.city")
    })
    Person fromPersonDTO(PersonDTO dto);
}