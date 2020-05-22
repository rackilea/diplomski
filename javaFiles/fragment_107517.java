public abstract class ExcelReader<T>{
     protected T value;
     protected GenericResolver resolver;

     public ExcelReader(T value) {
        super();
        resolver=ResolverFactory.createResolver(type.getClass()); 
     } 
}

public class POIReader<T> extends ExcelReader<T>{
    public POIReader(T value) {
        super(value);
    }
}