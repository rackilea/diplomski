package com.foo.bar;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.loader.WebappLoader;

public class SharedWebappLoader extends WebappLoader {

    private String pathID;
    private String pathConfig;

    static final ThreadLocal<ClassLoaderFactory> classLoaderFactory = new ThreadLocal<>();

    public SharedWebappLoader() {
        this(null);
    }

    public SharedWebappLoader(ClassLoader parent) {
        super(parent);
        setLoaderClass(SharedWebappClassLoader.class.getName());
    }

    public String getPathID() {
        return pathID;
    }

    public void setPathID(String pathID) {
        this.pathID = pathID;
    }

    public String getPathConfig() {
        return pathConfig;
    }

    public void setPathConfig(String pathConfig) {
        this.pathConfig = pathConfig;
    }

    @Override
    protected void startInternal() throws LifecycleException {
        classLoaderFactory.set(new ClassLoaderFactory(pathConfig, pathID));
        try {
            super.startInternal();
        } finally {
            classLoaderFactory.remove();
        }
    }

}