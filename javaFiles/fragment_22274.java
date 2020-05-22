@Mapper
public interface TestMapper {
    @Mappings({
        @Mapping(source = "dto", target = "ab", qualifiedByName = "toAB"),
    })
    Entity toEntity(Dto dto);

    @Mappings({
        @Mapping(target = "aId", source = "a.id"),
        @Mapping(target = "bId", source = "b.id"),
    })
    AB toAB(Dto dto);
}