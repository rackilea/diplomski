@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface CallMapper {

    @IterableMapping(qualifiedByName = "map")
    List<ConnectionDto> map(List<ConnectionEntity> connectionEntities);

    @BeanMapping( ignoreUnmappedSourceProperties={"id"} )
    ConnectionDto map(ConnectionEntity connectionEntity);
}