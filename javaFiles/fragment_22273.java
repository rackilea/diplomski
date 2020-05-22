@Mapper
public interface TestMapper {
    @Mappings({
        @Mapping(source = "a.id", target = "ab.aId", qualifiedByName = "toAB"),
        @Mapping(source = "b.id", target = "ab.bId", qualifiedByName = "toAB"),
    })
    Entity toEntity(Dto dto);
}