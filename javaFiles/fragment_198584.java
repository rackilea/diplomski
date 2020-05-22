@Mapper
public interface MyEntityMapper {

    @Mapping(target = "someString", qualifiedByName = "myFancyMapping")
    MyEventPayload toEventPayload(MyEntity entity);

    @Named("myFancyMapping") // org.mapstruct.Named
    default String mapSomeString(String value) {
        return value + " custom mapping ";
    }
}