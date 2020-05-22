package com.hillingar.server;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.servlet.GuiceServletContextListener;
import com.hillingar.server.dao.jdbcImpl.UserJdbc;
import com.hillingar.server.dao.interfaces.UserDao;
import com.hillingar.server.rest.UserService;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.sun.jersey.spi.container.servlet.ServletContainer;

// (1) Extend GuiceServletContextListener
public class ServletContextListener extends GuiceServletContextListener {

    Logger logger = Logger.getLogger(this.getClass().getName());

    // (1) Override getInjector
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new JerseyServletModule() {
            @Override
            protected void configureServlets() {
                bind(SecurityFilter.class).in(Singleton.class);
                bind(UserService.class);// .in(Singleton.class);
                bind(ServletContainer.class).in(Singleton.class);

                // (2) Change to using the GuiceContainer
                serve("/rest/*").with(GuiceContainer.class); // <<<<---

                bind(UserDao.class).to(UserJdbc.class);
                bind(SessionUtility.class);
            }
        });
    }
}