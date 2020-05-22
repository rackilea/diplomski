public class MyHandlerInstantiator extends HandlerInstantiator
{
    private final ObjectLocator objectLocator;

    public MyHandlerInstantiator(ObjectLocator objectLocator)
    {
        this.objectLocator = objectLocator;
    }

    @Override
    public JsonDeserializer<?> deserializerInstance(
     DeserializationConfig config, Annotated annotated, Class<?> deserClass)
    {
        // If null returned here instance will be created via reflection
        // you can always use objectLocator, or use it conditionally
        // just for some classes
        return objectLocator.autobuild(deserClass);
    }

    // Other method overrides can return null
}