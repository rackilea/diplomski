package com.example;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.catalina.Container;
import org.apache.catalina.ServerFactory;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.deploy.FilterDef;
import org.apache.catalina.deploy.FilterMap;

public class Tomcat6FilterConfigurator implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        StandardEngine engine = (StandardEngine) ServerFactory.getServer().findService("Catalina").getContainer();
        Container container = engine.findChild(engine.getDefaultHost());
        StandardContext context = (StandardContext) container.findChild(event.getServletContext().getContextPath());

        FilterDef filter1definition = new FilterDef();
        filter1definition.setFilterName(Filter1.class.getSimpleName());
        filter1definition.setFilterClass(Filter1.class.getName());
        context.addFilterDef(filter1definition);

        FilterMap filter1mapping = new FilterMap();
        filter1mapping.setFilterName(Filter1.class.getSimpleName());
        filter1mapping.addURLPattern("/*");
        context.addFilterMap(filter1mapping);

        // ...
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // TODO Auto-generated method stub

    }

}