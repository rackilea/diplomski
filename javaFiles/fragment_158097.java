@Mapper(
    componentModel = "spring", 
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, 
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)
public interface MyMapper {

    public Target mapFrom(Source source);

}