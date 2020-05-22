package com.test.log4j_test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App 
{

    private static final String CLASSNAME = "App.class";
    private static Logger LOGGER = Logger.getLogger(CLASSNAME);

    public static void main( String[] args ) throws FileNotFoundException,    IOException
    {
        LOGGER.logp(Level.WARNING, CLASSNAME, "TEST", "TEST__");
    }
}