@Mapper
public interface MyMapper extends FirstLibraryMapper<MyDomain, MyDto>, SecondLibraryMapper<MyDomain, MyDto> {

    @Override
    MyDto mapToDto(MyDomain domain);

}