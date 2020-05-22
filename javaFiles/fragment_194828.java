@Mapper(componentModel = "spring")
public abstract class Mapper {

    @Autowired
    private CityDAO cityDao;

    @Mappings({
            @Mapping(source = "street", target = "address.street"),
            @Mapping(source = "city", target = "address.city")
    })
    Person fromPersonDTO(PersonDTO dto);

    @AfterMapping
    void after(@MappingTarget Person person) {
        Address address = person.getAddress();
        if (address != null) {
            // additional null-checks might be required
            address.setStreet(address.getStreet().replaceAll(" ", "_")); 
            address.setCity(cityDao.findByName(address.getCity()).getId();
        }
    }
}