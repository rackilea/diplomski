package org.fao.oek.protocols.classpath;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Handler extends java.net.URLStreamHandler {
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        String resource = u.getPath();
        if (!resource.startsWith("/")) resource = "/" + resource;
        System.out.println(getClass().getResource(resource));
        return getClass().getResource(resource).openConnection();
    }
}