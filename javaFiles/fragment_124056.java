public class  Sample {

    //Create a static final object      
    private static final Sample INSTANCE = new Sample();

    //private constructor, so this class can't instantiated from outside
    private Sample() {
    }

    //Use the getInstance() static method which returns same instance always
    public static Sample getInstance() {
        return INSTANCE;
    }

    private String name = "Sample Enum";
    private String version = "1";
    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }
}

public class App {

    public App() {
        System.out.printf("%s - %s",Sample.getInstance().getName(),
          Sample.getInstance().getVersion());
    }
}