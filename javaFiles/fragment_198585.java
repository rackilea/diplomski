@Qualifier // org.mapstruct.Qualifier
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface MyFancyMapping {
}

@Mapper
public interface MyEntityMapper {

    @Mapping(target = "someString", qualifiedBy = MyFancyMapping.class)
    MyEventPayload toEventPayload(MyEntity entity);

    @MyFancyMapping
    default String mapSomeString(String value) {
        return value + " custom mapping ";
    }
}