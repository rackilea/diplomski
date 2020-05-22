@Provider // or register in the configuration...
public class DTOMapperFeature implements DynamicFeature {
  @Override
  public void configure(ResourceInfo resourceInfo, FeatureContext context) {
    for (Annotation annotation : resourceInfo.getResourceMethod().getAnnotations()) {
      if (annotation instanceof MapTo) {
        MapTo mapTo = (MapTo) annotation;
        // Note: additional validation (return type shouldn't be void, 
        // collections are out etc.) is required before creating this,
        // or should be pushed in the DTOMapperFilter.
        // You get the gist: this filter will map the entity to an instance
        // of the specified class (using a constructor in this case).
        context.register(new DTOMapperFilter(
          resourceInfo.getResourceMethod().getReturnType(), 
          mapTo.getResponseType());
      }
    }
  }
  @Priority(/* appropriate priority here! */)
  public final static class DTOMapperFilter implements ContainerResponseFilter {
    public DTOMapperFilter(Class<?> declaredReturnType, Class<?> responseType) { 
      // implementation omitted: find DTO constructor etc.
      // throw if responseType does NOT have a constructor that takes an instance
      // of declaredReturnType: catch errors at application bootstrap!
    }
    @Override
    public void filter(
      ContainerRequestContext requestContext, 
      ContainerResponseContext responseContext) throws IOException {
        // implementation omitted: create instance of DTO class using constructor
      }
  }
}