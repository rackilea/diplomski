package com.stackoverflow.Q12082277;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author maba, 2012-08-23
 */
public class App {

    public static void main(String[] args) throws IOException {
        ClassLoader loader = App.class.getClassLoader();
        InputStream in = loader.getResourceAsStream("app.properties");
        Properties properties = new Properties();
        properties.load(in);
        properties.list(System.out);
    }
}