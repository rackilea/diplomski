package com.lm.infrastructure;

import java.io.IOException;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;

@Provider
public class RequestResponseFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @Override
    public void filter( ContainerRequestContext requestContext ) throws IOException {
        log.warn( "> {} {} {}",
                requestContext.getRequest().getMethod(),
                requestContext.getUriInfo().getAbsolutePath(),
                IOUtils.readLines( requestContext.getEntityStream() )
        );
        System.out.println( "Cookies: " + requestContext.getCookies() );
    }

    @Override
    public void filter( ContainerRequestContext requestContext, ContainerResponseContext responseContext ) throws IOException {
        log.warn( "Entity: {}", responseContext.getEntity() );
    }

    @Inject
    Logger log;
}