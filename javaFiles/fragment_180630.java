@Mapper
public interface DtoMapper {

    @Mapping( target = "amount", source = "request" /* the param name */ )
    MyDto convert(IncomingRequest request);

    // @Mapping( /* what should I use here ? Answer: nothing its an implemented method.. @Mapping does not make sense */ )
    default Amount createAmount(IncomingRequest request) {
        long value = ....
        int exponent = ....
        int currency = ....
        return new Amount(value, exponent, currency);
}