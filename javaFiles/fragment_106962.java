@ExceptionHandler(value = Exception.class)
public void defaultErrorHandler(Exception e) throws Exception {

    RaygunClient client = new RaygunClient("<MyRaygunAPIKey>");

    // If the exception is annotated with @ResponseStatus rethrow it and let
    // the framework handle it
    if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
        throw e;
    }

    // Otherwise send the exception Raygun and then rethrow it and let the framework handle it
    if (accessToken.getUsername() != null && accessToken.getDatabaseName() != null) {
        ArrayList tags = new ArrayList<String>();
        tags.add("username: " + accessToken.getUsername());
        tags.add("database: " + accessToken.getDatabaseName());
        client.Send(e, tags);
        accessToken = null;
        throw e;

    } else if (databaseName != null) {
        ArrayList tags = new ArrayList<String>();
        tags.add("database: " + databaseName);
        client.Send(e, tags);
        databaseName = null;
        throw e;

    } else {
        client.Send(e);
        throw e;
    }
}