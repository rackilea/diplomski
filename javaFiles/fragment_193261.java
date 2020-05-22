package com.foo.bar;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.loader.ResourceEntry;
import org.apache.catalina.loader.WebappClassLoader;

import java.net.URL;

public class SharedWebappClassLoader extends WebappClassLoader {

    public SharedWebappClassLoader(ClassLoader parent) {
        super(SharedWebappLoader.classLoaderFactory.get().create(parent));
    }

    @Override
    protected ResourceEntry findResourceInternal(String name, String path) {
        ResourceEntry entry = super.findResourceInternal(name, path);
        if(entry == null) {
            URL url = parent.getResource(name);
            if (url == null) {
                return null;
            }

            entry = new ResourceEntry();
            entry.source = url;
            entry.codeBase = entry.source;
        }
        return entry;
    }

    @Override
    public void stop() throws LifecycleException {
        ClassLoaderFactory.removeLoader(parent);
    }
}