package com.stackoverflow.question.jersey.with.spring;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * Spring HelloWorld Web Application configuration.
 * 
 * @author Jakub Podlesak (jakub.podlesak at oracle.com)
 */
public class MyApplication extends ResourceConfig
{

    /**
     * Register JAX-RS application components.
     */
    public MyApplication()
    {
        packages(true, "com.stackoverflow.question.jersey.with.spring");
    }
}