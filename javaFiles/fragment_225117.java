public interface Resource {
  // some methods
} 

public interface ResourceFactory {
  boolean acceptsResource(String resource);
  Resource createResource(String resource) throws UnsupportedResourceException;
}   

public final MultiResourceFactory implements ResourceFactory{
   private static final ServiceLoader<ResourceFactory > resourceFactoryLoader
       = ServiceLoader.load(ResourceFactory .class);
   private static final MultiResourceFactory INSTANCE;

  private MultiResourceFactory(){
  }

  public static MultiResourceFactory getInstance(){
    if (INSTANCE == null){
        INSTANCE = new MultiResourceFactory();
    }
    return INSTANCE;
  }
  @Override
  public boolean acceptsResource(String resource){
      for (ResourceFactory resourceFactory : resourceFactoryLoader) {
         if (resourceFactory.acceptsResource(resource)){
             return true;
         }
      }
      return false;
  }

  @Override
  public Resource createResource(String resource) throws UnsupportedResourceException{
      for (ResourceFactory resourceFactory : resourceFactoryLoader) {
         if (resourceFactory.acceptsResource(resource)){
             return resourceFactory.createResource(resource);
         }
      }
      throw new UnsupportedResourceException(resource);
  }