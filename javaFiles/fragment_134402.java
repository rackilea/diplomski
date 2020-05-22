@Mapper
    public interface ObjectMapper {

        ObjectMapper INSTANCE = Mappers.getMapper( ObjectMapper.class );

        @Mapping(source = "totalAmount", target = "totalAmount")
        ObjectWantSend objectWantSend(DaoObjectProjection aux);
    }