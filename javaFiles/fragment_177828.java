@Mapper( uses = MappingUtil.class )
public interface SourceTargetMapper {

    SourceTargetMapper MAPPER = Mappers.getMapper( SourceTargetMapper.class );

    @Mappings( {
        @Mapping(source = "map", target = "ip", qualifiedBy = MappingUtil.Ip.class ),
        @Mapping(source = "map", target = "server", qualifiedBy = MappingUtil.Server.class ),
    } )
    Target toTarget( Source s );
}