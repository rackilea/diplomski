public class SomeExportType implements IExportType{

    protected String name;
    @Autowired(@Qualifier="SomeFetchingStrategy")      
    protected IFetchingStrategy fetchStg;
    @Autowired(@Qualifier="SomeExportStrategy")      
    protected IExportStrategy exportStg;



    // ...
}

public interface IExportType {
     public void doSomething();  //
}

public interface IFetchingStrategy {
   public void fetch();
}

public class SomeFetchingStrategy implements IFetchingStrategy {

    public void fetch() {
        //implement this strategy
    }

}