package com.foo.bar;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ClassLoaderFactory {

    private static final class ConfigKey {
        private final String pathConfig;
        private final String pathID;
        private ConfigKey(String pathConfig, String pathID) {
            this.pathConfig = pathConfig;
            this.pathID = pathID;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ConfigKey configKey = (ConfigKey) o;

            if (pathConfig != null ? !pathConfig.equals(configKey.pathConfig) : configKey.pathConfig != null)
                return false;
            if (pathID != null ? !pathID.equals(configKey.pathID) : configKey.pathID != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = pathConfig != null ? pathConfig.hashCode() : 0;
            result = 31 * result + (pathID != null ? pathID.hashCode() : 0);
            return result;
        }
    }

    private static final Map<ConfigKey, ClassLoader> loaders = new HashMap<>();
    private static final Map<ClassLoader, ConfigKey> revLoaders = new HashMap<>();
    private static final Map<ClassLoader, Integer> usages = new HashMap<>();

    private final ConfigKey key;

    public ClassLoaderFactory(String pathConfig, String pathID) {
        this.key = new ConfigKey(pathConfig, pathID);
    }

    public ClassLoader create(ClassLoader parent) {
        synchronized (loaders) {
            ClassLoader loader = loaders.get(key);
            if(loader != null) {
                Integer usageCount = usages.get(loader);
                usages.put(loader, ++usageCount);
                return loader;
            }

            Properties props = new Properties();
            try (InputStream is = new BufferedInputStream(new FileInputStream(key.pathConfig))) {
                props.load(is);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String libsStr = props.getProperty(key.pathID);
            String[] libs = libsStr.split(File.pathSeparator);
            URL[] urls = new URL[libs.length];
            try {
                for(int i = 0, len = libs.length; i < len; i++) {
                    urls[i] = new URL(libs[i]);
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

            loader = new URLClassLoader(urls, parent);
            loaders.put(key, loader);
            revLoaders.put(loader, key);
            usages.put(loader, 1);

            return loader;
        }
    }

    public static void removeLoader(ClassLoader parent) {
        synchronized (loaders) {
            Integer val = usages.get(parent);
            if(val > 1) {
                usages.put(parent, --val);
            } else {
                usages.remove(parent);
                ConfigKey key = revLoaders.remove(parent);
                loaders.remove(key);
            }
        }
    }

}