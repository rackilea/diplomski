import com.wordnik.swagger.annotations.ApiOperation;
import org.glassfish.jersey.server.model.Resource;
import org.glassfish.jersey.server.model.ResourceMethod;

public class ApiScanner {
    public static void main(String[] args) {
        ApiScanner scanner = new ApiScanner();
        scanner.xyz();
    }

    public void xyz() {
        Resource resource = Resource.from(BaseResource.class);
        abc(resource.getPath(), resource);
    }

    public void abc(String uriPrefix, Resource resource) {
        for (ResourceMethod resourceMethod: resource.getResourceMethods()) {
            String uri = uriPrefix;
            System.out.println("-- Resource Method --");
            System.out.println(resourceMethod.getHttpMethod() + "\t" + uri);
            ApiOperation api = resourceMethod.getInvocable().getDefinitionMethod()
                                                .getAnnotation(ApiOperation.class);
        }

        for (Resource childResource: resource.getChildResources()) {
            System.out.println("-- Child Resource --");
            System.out.println(childResource.getPath() + "\t" + childResource.getName());

            if (childResource.getResourceLocator() != null) {
                System.out.println("-- Sub-Resource Locator --");
                ResourceMethod method = childResource.getResourceLocator();
                Class locatorType = method.getInvocable().getRawResponseType();
                System.out.println(locatorType);
                Resource subResource = Resource.from(locatorType);
                abc(childResource.getPath(), subResource);        
            }
        }
    }
}