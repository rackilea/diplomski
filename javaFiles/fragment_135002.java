@Provider
@FortressProtected
public class FortressAuthorizer implements ContainerRequestFilter {

  @Context
  ResourceInfo resourceInfo;

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {

    Class<?> resourceClass = resourceInfo.getResourceClass();
    FortressProtected classAnnot = resourceClass.getAnnotation(FortressProtected.class);
    if (classAnnot != null) {
      // do something with annotation
    }

    Method resourceMethod = resourceInfo.getResourceMethod();
    FortressProtected methodAnnot = resourceMethod.getAnnotation(FortressProtected.class);
    if (methodAnnot != null) {
      // do something with annotation
    }
  }
}