package com.stackoverflow.question.jersey.with.spring;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import com.stackoverflow.question.jersey.with.spring.CategoryManagerFactory.CategoryManagerTypes;

@Path("jersey-hello")
public class JerseyResource
{
    @Inject
    private CategoryManagerFactory categoryManagerFactory;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello(@Context HttpHeaders headers, @QueryParam("category") CategoryManagerTypes category)
    {
        CategoryManager categoryManager = categoryManagerFactory.obtainCategoryManager(category);

        return categoryManager.saySomething();
    }
}