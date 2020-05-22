import org.codehaus.jackson.map.ObjectMapper;

public class MyClass<T> implements IMyInterface<String, T> {

   private Class<T> clazz;

   public MyClass(Class<T> clazz) {
    this.clazz = clazz;
   }

   @Override
   public T myMethod(String jsonString) throws Exception {
       ObjectMapper mapper = new ObjectMapper();
       T result = mapper.readValue(jsonString, clazz); 
       return result;
   }