import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class SecurityInterceptor implements ContainerRequestFilter, ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext reqCtx, ContainerResponseContext respCtx) throws IOException {

        long startTime=0;
        System.out.println("Adding ProcessingTime in response headers"); 
        if(reqCtx.getHeaderString("startTime")!=null)
        startTime = Long.parseLong(reqCtx.getHeaderString("startTime")); 
        respCtx.getHeaders().add("ProcessingTime",
                String.valueOf(System.currentTimeMillis() - startTime) + " millisecs"); 
    }

    @Override
    public void filter(ContainerRequestContext reqCtx) throws IOException {
        System.out.println("Adding start time in request headers");

        reqCtx.getHeaders().add("startTime", String.valueOf(System.currentTimeMillis()));

    }

}