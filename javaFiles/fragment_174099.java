@Module(injects = Foo.class)
public class SomeModule {
    @Provide
    @Named("FooDependency")
    public List<String> provideFooDependencyListOfString() {
        return Arrays.asList("1", "2", "3");
    }
}