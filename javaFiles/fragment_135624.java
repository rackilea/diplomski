import com.sun.jersey.api.model.AbstractResource;
import com.sun.jersey.api.model.AbstractSubResourceMethod;
import com.sun.jersey.server.impl.modelapi.annotation.IntrospectionModeller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class AnimalsTest
{
   public static void main(String [] args)
   {
      AbstractResource resource = IntrospectionModeller.createResource(AnimalResource.class);
      System.out.println("Path is " + resource.getPath().getValue());

      String uriPrefix = resource.getPath().getValue();
      for (AbstractSubResourceMethod srm :resource.getSubResourceMethods())
      {
         String uri = uriPrefix + "/" + srm.getPath().getValue();
         System.out.println(srm.getHttpMethod() + " at the path " + uri + " return " + srm.getReturnType().getName());
      }
   }
}