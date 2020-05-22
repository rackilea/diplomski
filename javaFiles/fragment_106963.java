@ExceptionHandler(value = Exception.class)
public void defaultErrorHandler(Exception e) throws Exception {

    RaygunClient client = new RaygunClient("<MyRaygunAPIKey>");

    // If the exception is annotated with @ResponseStatus rethrow it and let the framework handle it
    if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
        throw e;
    }
    // Otherwise send the exception Raygun and then rethrow it and let the framework handle it
    else {
        client.Send(e);
        throw e;
    }
}