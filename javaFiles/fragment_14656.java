import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import path.to.MyException;

@Provider
public class EntityResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter( ContainerRequestContext reqc , ContainerResponseContext resc ) throws IOException {
        List<MediaType> mediaTypes = reqc.getAcceptableMediaTypes();
        MediaType mediaType = new MediaType("application", "vnd-mycompany-error");
        if( mediaTypes.contains( mediaType) && resc.getEntity() instanceof MyDao /* or MyDto, or null, or whatever */) {   
            resc.setEntity( resc.getEntity(), new Annotation[0], mediaType );
        }
        // ...
    }
}