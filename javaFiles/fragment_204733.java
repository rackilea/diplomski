@Mapper
public interface MySourceMapper {
  @Mapping(...)
  FooClass mapToFoo(MySource source);

  @Mapping(...)
  BarClass mapToBar(MySource source);
}