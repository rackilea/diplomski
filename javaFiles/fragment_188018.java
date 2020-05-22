@Mapper
public interface MyMapper {

    @Mapping(target = "x", expression = "java(a.x + b.x)")
    @Mapping(target = "y", expression = "java(a.y + b.y)")
    C map(A a, B b);
}