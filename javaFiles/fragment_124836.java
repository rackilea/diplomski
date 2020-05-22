@Component
@Service(value=org.apache.sling.api.adapter.AdapterFactory.class)
@Properties({
   @Property(name = "adaptables", value = { "org.apache.sling.api.resource.Resource" }),
   @Property(name = "adapters", value = { "org.sling.MyClass" })
})
public class MyAdapterFactory implements AdapterFactory{
    public  <AdapterType> AdapterType getAdapter(final Object adaptable, Class<AdapterType> type){
          return new MyClassAdapter(adaptable);   
    }     
}