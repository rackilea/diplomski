package com.rest;

import org.glassfish.jersey.server.ResourceConfig;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class MyApplication extends ResourceConfig {

    public MyApplication() {
        packages("com.rest");
        register(JacksonJsonProvider.class);
    }