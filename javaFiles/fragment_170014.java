// Common Code Package
public abstract class Operations {

    private static final Logger LOGGER = LoggerFactory.getLogger(Operations.class);

    public enum MyOperation {
        CREATE, RETRIEVE, UPDATE, DELETE
    }


    protected MyCustomObject custom;
    protected String operation; 

    public void on(MyOperation operation, Object instance, MyCustomObject custom){

        // Change 'operation' to Standard Case e.g. CREATE => Create
        String lower = operation.name().toLowerCase();
        String value = lower.substring(0, 1).toUpperCase() + lower.substring(1);

        // Delegate Invocation
        on(value, obj, custom);
    }
    public void on(String operation, Object instance, MyCustomObject custom){

        this.custom = custom;
        this.operation = operation;

        if(operation == null){
            throw new IllegalArgumentException("'operation' is invalid");
        }
        if(instance == null){
            throw new IllegalArgumentException("'instance' is invalid");
        }
        if(custom == null){
            throw new IllegalArgumentException("'custom' is invalid");
        }

        /* Other Logic */

        try {
            String methodName = String.format("on%s", operation);
            this.getClass().getDeclaredMethod(methodName, Object.class).invoke(this, obj);

        } catch(IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException e){
            LOGGER.error("ERROR: {}", e);
        }


        /* More Logic */


        if(!custom.isOkay()){
            throw new IllegalStateException("Not Okay");
        }
    }    


    public void onCreate(Object instance) {
        throw new UnsupportedOperationException("Create Operation Not Supported!");
    }

    public void onRetrieve(Object instance) {
        throw new UnsupportedOperationException("Retrieve Operation Not Supported!");
    }

    public void onUpdate(Object instance) {
        throw new UnsupportedOperationException("Update Operation Not Supported!");
    }

    public void onDelete(Object instance) {
        throw new UnsupportedOperationException("Delete Operation Not Supported!");
    }
}