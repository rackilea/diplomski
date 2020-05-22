@Mapper
public interface AMapper {

    AMapper INSTANCE = Mappers.getMapper(AMapper.class);

    @Mapping(source = "b.b", target = "b")
    Y aToY(A a);
}