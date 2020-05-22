package com.example.core;

import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;
import com.example.ws.HeyResource;
import org.glassfish.jersey.servlet.ServletContainer;

import java.util.Map;
import java.util.TreeMap;

class JerseyServletModuleConfig extends ServletModule {
    @Override
    protected void configureServlets() {
        bind(HeyResource.class).in(Scopes.SINGLETON);
    }
}