public class WeldJUnit4Runner extends BlockJUnit4ClassRunner {  

private final Class<?> clazz;  
private final Weld weld;  
private final WeldContainer container;  

public WeldJUnit4Runner(final Class<Object> clazz) throws InitializationError {  
    super(clazz);  
    this.clazz = clazz;  
    // Do weld initialization here. You should remove your weld initialization code from your Test class.
    this.weld = new Weld();  
    this.container = weld.initialize();  
}  

@Override  
protected Object createTest() throws Exception {  
    return container.instance().select(clazz).get();    
}  
}