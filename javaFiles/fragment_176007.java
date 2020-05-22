package com.yourcompany.app.package;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.yourcompany.annotated.package.*;

public class WSApplication extends Application {

    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(route.class);
        return s;
    }
}