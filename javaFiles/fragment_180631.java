@Mapper
public interface DtoMapper {

    @Mapping( target = amount, ignore = true /* leave it to after mapping */ )
    MyDto convert(IncomingRequest request);

    @AfterMapping(  )
    default void createAmount(IncomingRequest request, @MappingTarget MyDto dto) {
        // which completes the stuff you cannot do
        dto.setAmount( new Amount(value, exponent, currency) );
}