@Mapper
public interface MyMapper {

    @Mapping(target = "x", expression = "java(Math.pow(a.x, b.x))")
    @Mapping(target = "y", expression = "java(Math.pow(a.y, b.y))")
    C map(A a, B b);
}