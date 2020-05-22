public class GenericHandlerFactory {
    private final GenericHandlerFactory instance = new GenericHandlerFactory();

    private GenericHandlerFactory() {}

    public GenericHandler getInstance() { return this.instance; }

    public GenericHandler createHandler(Class genericHandlerClass) {
        GenericHandler result = null;
        // Code to create the GenericHandler you want.
        return result;
    }    
}