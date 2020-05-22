@Mapper
public interface ConfigsMapper {
    ConfigsMapper INSTANCE = Mappers.getMapper(ConfigsMapper.class);

    @Mappings({ 
        @Mapping(source = "configs1", target = "configsDTO1"),
        @Mapping(source = "configs2", target = "configsDTO2"),
        @Mapping(target = "somethingElse", constant="somethingElseOnDTO")
    })
    ConfigsDTO ConfigsToConfigsDTO(Configs configs);

    @InheritInverseConfiguration
    Configs toConfigs(ConfigsDTO configsDTO);
}