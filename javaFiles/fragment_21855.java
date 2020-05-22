public abstract class AbstractRESTClientService<E extends IDable<String>> 
    implements GenericService<E, String> {


private Class<E> classType;
private Class<E[]> classArray;
private String controllerPath;

@SuppressWarnings("unchecked")
public AbstractRESTClientService(final Class<E[]> classArray, 
    final String controllerPath) {
        this.classType = (Class<E>) classArray.getComponentType();
        this.classArray = classArray;
        this.controllerPath = controllerPath;
        this.webService = new GenericWebClientService<E>();
    }

    // ... other methods
}