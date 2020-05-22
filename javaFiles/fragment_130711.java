// Retrieve the field "factory" of the class URL that store the 
// URLStreamHandlerFactory used
Field factoryField = URL.class.getDeclaredField("factory");
// It is a package protected field so we need to make it accessible
factoryField.setAccessible(true);
// Get the current value
URLStreamHandlerFactory urlStreamHandlerFactory 
    = (URLStreamHandlerFactory) factoryField.get(null);
if (urlStreamHandlerFactory == null) {
    // No factory has been defined so far so we set the custom one
    URL.setURLStreamHandlerFactory(new S3URLStreamHandlerFactory());
} else {
    // Retrieve the field "streamHandlerLock" of the class URL that
    // is the lock used to synchronize access to the protocol handlers 
    Field lockField = URL.class.getDeclaredField("streamHandlerLock");
    // It is a private field so we need to make it accessible
    lockField.setAccessible(true);
    // Use the same lock to reset the factory
    synchronized (lockField.get(null)) {
        // Reset the value to prevent Error due to a factory already defined
        factoryField.set(null, null);
        // Set our custom factory and wrap the current one into it
        URL.setURLStreamHandlerFactory(
            new S3URLStreamHandlerFactory(urlStreamHandlerFactory)
        );
    }
}