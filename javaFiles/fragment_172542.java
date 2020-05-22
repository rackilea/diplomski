package com.example.q45313762;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class ConfigurableClasspathClassLoader extends URLClassLoader {

    public interface Configuration {

        interface Module {

            String getName();

            String getVersion();

            boolean includes(String resourceName);

        }

        interface Library extends Module {}

        interface Application extends Module {}

        enum LoadingMode {
            STATIC, DYNAMIC;
        }

        Application getCurrentApplication();

        Iterable<URL> getLibrarySearchPath(Library lib, LoadingMode mode, Application app);

        Iterable<URL> getApplicationSearchPath(Application app);

        Iterable<Library> getApplicationLibraries(Application app);

    }

    public static final class SimpleStaticConfiguration implements Configuration {

        private static abstract class SimpleModule implements Module {

            private final String name, version;
            private final Predicate<String> resourceNameMatcher;

            private SimpleModule(String name, String version, Predicate<String> resourceNameMatcher) {
                requireNoneNull(name, version, resourceNameMatcher);
                name = name.trim();
                version = version.trim();
                if (name.isEmpty() || version.isEmpty()) {
                    throw new IllegalArgumentException("arguments must not be empty.");
                }
                this.name = name;
                this.version = version;
                this.resourceNameMatcher = resourceNameMatcher;
            }

            @Override
            public String getName() {
                return name;
            }

            @Override
            public String getVersion() {
                return version;
            }

            @Override
            public boolean includes(String resourceName) {
                if (resourceName == null) {
                    return false;
                }
                return resourceNameMatcher.test(resourceName);
            }

            @Override
            public final int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((name == null) ? 0 : name.hashCode());
                result = prime * result + ((resourceNameMatcher == null) ? 0 : resourceNameMatcher.hashCode());
                result = prime * result + ((version == null) ? 0 : version.hashCode());
                return result;
            }

            @Override
            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null) {
                    return false;
                }
                if (!(obj instanceof SimpleModule)) {
                    return false;
                }
                SimpleModule other = (SimpleModule) obj;
                if (name == null) {
                    if (other.name != null) {
                        return false;
                    }
                }
                else if (!name.equals(other.name)) {
                    return false;
                }
                if (resourceNameMatcher == null) {
                    if (other.resourceNameMatcher != null) {
                        return false;
                    }
                }
                else if (!resourceNameMatcher.equals(other.resourceNameMatcher)) {
                    return false;
                }
                if (version == null) {
                    if (other.version != null) {
                        return false;
                    }
                }
                else if (!version.equals(other.version)) {
                    return false;
                }
                return true;
            }

        }

        public static final class SimpleLibrary extends SimpleModule implements Library {

            public SimpleLibrary(String name, String version, Predicate<String> resourceNameMatcher) {
                super(name, version, resourceNameMatcher);
            }

        }

        public static final class SimpleApplication extends SimpleModule implements Application {

            public SimpleApplication(String name, String version, Predicate<String> resourceNameMatcher) {
                super(name, version, resourceNameMatcher);
            }

        }

        private static final class ModuleRegistry {

            private static abstract class Key {

                private final Module module;

                private Key(Module module) {
                    requireNoneNull(module);
                    requireNoneNull(module.getName(), module.getVersion());
                    this.module = module;
                }

                private Module getModule() {
                    return module;
                }

            }

            private static final class LibraryKey extends Key {

                private final LoadingMode mode;
                private final Application app;

                private LibraryKey(Library lib, LoadingMode mode, Application app) {
                    super(lib);
                    requireNoneNull(mode);
                    requireNoneNull(app);
                    this.mode = mode;
                    this.app = app;
                }

                private Library getLibrary() {
                    return (Library) super.getModule();
                }

                private LoadingMode getLoadingMode() {
                    return mode;
                }

                private Application getApplication() {
                    return app;
                }

                @Override
                public int hashCode() {
                    final int prime = 31;
                    int result = 1;
                    Library lib = getLibrary();
                    result = prime * result + ((lib == null) ? 0 : lib.hashCode());
                    result = prime * result + ((mode == null) ? 0 : mode.hashCode());
                    result = prime * result + ((app == null) ? 0 : app.hashCode());
                    return result;
                }

                @Override
                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null) {
                        return false;
                    }
                    if (!(obj instanceof LibraryKey)) {
                        return false;
                    }
                    LibraryKey other = (LibraryKey) obj;
                    Library thisLib = getLibrary(), othersLib = other.getLibrary();
                    if (thisLib == null) {
                        if (othersLib != null) {
                            return false;
                        }
                    }
                    else if (!thisLib.equals(othersLib)) {
                        return false;
                    }
                    if (mode != other.mode) {
                        return false;
                    }
                    if (app == null) {
                        if (other.app != null) {
                            return false;
                        }
                    }
                    else if (!app.equals(other.app)) {
                        return false;
                    }
                    return true;
                }

            }

            private static final class ApplicationKey extends Key {

                private ApplicationKey(Application app) {
                    super(app);
                }

                private Application getApplication() {
                    return (Application) super.getModule();
                }

                @Override
                public int hashCode() {
                    final int prime = 31;
                    int result = 1;
                    Application app = getApplication();
                    result = prime * result + ((app == null) ? 0 : app.hashCode());
                    return result;
                }

                @Override
                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null) {
                        return false;
                    }
                    if (!(obj instanceof ApplicationKey)) {
                        return false;
                    }
                    ApplicationKey other = (ApplicationKey) obj;
                    Application thisApp = getApplication(), othersApp = other.getApplication();
                    if (thisApp == null) {
                        if (othersApp != null) {
                            return false;
                        }
                    }
                    else if (!thisApp.equals(othersApp)) {
                        return false;
                    }
                    return true;
                }

            }

            private static final class Value {

                private final Set<URL> searchPath;

                private Value(URL... searchPath) {
                    requireNoneNull((Object) searchPath);
                    if (searchPath == null || searchPath.length == 0) {
                        this.searchPath = EMPTY_SEARCH_PATH;
                    }
                    else {
                        this.searchPath = new LinkedHashSet<>(Arrays.asList(searchPath));
                        Iterator<URL> itr = this.searchPath.iterator();
                        while (itr.hasNext()) {
                            URL searchPathEntry = itr.next();
                            String proto = searchPathEntry.getProtocol();
                            if ("file".equals(proto) || "jar".equals(proto)) {
                                continue;
                            }
                            itr.remove();
                        }
                        verify();
                    }
                }

                private Set<URL> getSearchPath() {
                    verify();
                    return (searchPath == EMPTY_SEARCH_PATH) ? searchPath : Collections.unmodifiableSet(searchPath);
                }

                private void verify() {
                    Iterator<URL> itr = searchPath.iterator();
                    while (itr.hasNext()) {
                        try {
                            if (!Files.exists(Paths.get(itr.next().toURI()))) {
                                itr.remove();
                            }
                        }
                        catch (IllegalArgumentException | URISyntaxException | SecurityException e) {
                            itr.remove();
                        }
                    }
                }

                @Override
                public int hashCode() {
                    final int prime = 31;
                    int result = 1;
                    result = prime * result + ((searchPath == null) ? 0 : searchPath.hashCode());
                    return result;
                }

                @Override
                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null) {
                        return false;
                    }
                    if (!(obj instanceof Value)) {
                        return false;
                    }
                    Value other = (Value) obj;
                    if (searchPath == null) {
                        if (other.searchPath != null) {
                            return false;
                        }
                    }
                    else if (!searchPath.equals(other.searchPath)) {
                        return false;
                    }
                    return true;
                }

            }

            private final Map<Key, Value> m = new LinkedHashMap<>();
            private Supplier<Application> appProvider;

            private ModuleRegistry() {
            }

            private ModuleRegistry(ModuleRegistry mr) {
                m.putAll(mr.m);
                appProvider = mr.appProvider;
            }

            private void putLibraryEntry(Library lib, LoadingMode mode, Application app, URL... searchPath) {
                m.put(new LibraryKey(lib, mode, app), new Value(searchPath));
            }

            private void putApplicationEntry(Application app, URL... searchPath) {
                m.put(new ApplicationKey(app), new Value(searchPath));
            }

            private Set<Library> getLibraries(Application app) {
                Set<Library> ret = null;
                for (Key k : m.keySet()) {
                    if (!(k instanceof LibraryKey)) {
                        continue;
                    }
                    LibraryKey lk = (LibraryKey) k;
                    if (lk.getApplication().equals(app)) {
                        if (ret == null) {
                            ret = new LinkedHashSet<>();
                        }
                        ret.add(lk.getLibrary());
                    }
                }
                if (ret == null) {
                    ret = NO_LIBS;
                }
                return ret;
            }

            private Set<URL> getLibrarySearchPath(Library lib, LoadingMode mode, Application app) {
                Set<URL> ret = EMPTY_SEARCH_PATH;
                Value v = m.get(new LibraryKey(lib, mode, app));
                if (mode == LoadingMode.DYNAMIC && (v == null || v.getSearchPath().isEmpty())) {
                    v = m.get(new LibraryKey(lib, LoadingMode.STATIC, app));
                }
                if (v != null) {
                    ret = v.getSearchPath();
                }
                return ret;
            }

            private Set<URL> getApplicationSearchPath(Application app) {
                Set<URL> ret = EMPTY_SEARCH_PATH;
                Value v = m.get(new ApplicationKey(app));
                if (v != null) {
                    ret = v.getSearchPath();
                }
                return ret;
            }

            private Supplier<Application> getApplicationProvider() {
                return appProvider;
            }

            private void setApplicationProvider(Supplier<Application> appProvider) {
                requireNoneNull(appProvider);
                requireNoneNull(appProvider.get());
                this.appProvider = appProvider;
            }

            private void clear() {
                m.clear();
            }

        }

        public static final class Builder {

            private final ModuleRegistry registry = new ModuleRegistry();

            private Builder() {
            }

            public synchronized Builder withLibrary(Library lib, LoadingMode mode, Application app, URL... searchPath) {
                registry.putLibraryEntry(lib, mode, app, searchPath);
                return this;
            }

            public synchronized Builder withApplication(Application app, URL... searchPath) {
                registry.putApplicationEntry(app, searchPath);
                return this;
            }

            public synchronized Builder withApplicationProvider(Supplier<Application> appProvider) {
                registry.setApplicationProvider(appProvider);
                return this;
            }

            public synchronized SimpleStaticConfiguration build() {
                SimpleStaticConfiguration ret = new SimpleStaticConfiguration(this);
                registry.clear();
                return ret;
            }

            public synchronized Builder reset() {
                registry.clear();
                return this;
            }

        }

        public static final Set<URL> EMPTY_SEARCH_PATH = Collections.emptySet();
        private static final Set<Library> NO_LIBS = Collections.emptySet();

        public static Builder newBuilder() {
            return new Builder();
        }

        private final ModuleRegistry registry;

        private SimpleStaticConfiguration(Builder b) {
            registry = new ModuleRegistry(b.registry);
        }

        @Override
        public Application getCurrentApplication() {
            return registry.getApplicationProvider().get();
        }

        @Override
        public Iterable<URL> getLibrarySearchPath(Library lib, LoadingMode mode, Application app) {
            return registry.getLibrarySearchPath(lib, mode, app);
        }

        @Override
        public Iterable<URL> getApplicationSearchPath(Application app) {
            return registry.getApplicationSearchPath(app);
        }

        @Override
        public Iterable<Library> getApplicationLibraries(Application app) {
            return registry.getLibraries(app);
        }

    }

    private static final String JAVA_HOME_PROP = System.getProperty("java.home");

    private static void requireNoneNull(Object... args) {
        if (args != null) {
            for (Object o : args) {
                Objects.requireNonNull(o);
            }
        }
    }

    private final Lock readLock, writeLock;
    private Configuration cfg;

    {
        ReadWriteLock rwl = new ReentrantReadWriteLock(false);
        readLock = rwl.readLock();
        writeLock = rwl.writeLock();
    }

    public ConfigurableClasspathClassLoader(Configuration cfg, ClassLoader parent) {
        super(new URL[0], parent);
        setConfiguration(cfg);
    }

    public void setConfiguration(Configuration cfg) {
        requireNoneNull(cfg);
        try {
            writeLock.lock();
            this.cfg = cfg;
        }
        finally {
            writeLock.unlock();
        }
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        if (name == null) {
            throw new ClassNotFoundException(name);
        }
        synchronized (getClassLoadingLock(name)) {
            Class<?> ret;
            Class<?> self = getClass();
            if (self.getName().equals(name)) {
                // no need to "reload" our own class
                return self;
            }
            ret = findLoadedClass(name);
            if (ret != null) {
                // already loaded
                return ret;
            }
            // unknown
            ret = findClass(name);
            if (resolve) {
                resolveClass(ret);
            }
            return ret;
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // perform a search on the global classpath (obviously far from ideal)
        Enumeration<URL> allMatches;
        String modifiedName = name.replace(".", "/").concat(".class");
        try {
            allMatches = getResources(modifiedName);
        }
        catch (IOException ioe) {
            throw new ClassNotFoundException(name);
        }
        Set<URL> filteredMatches = new LinkedHashSet<>();
        while (allMatches.hasMoreElements()) {
            URL match = allMatches.nextElement();
            if (match.getPath().replaceFirst("file:", "").startsWith(JAVA_HOME_PROP)) {
                // probably a bootstrap classpath class - these are off limits to us
                return getParent().loadClass(name);
            }
            // candidate match
            filteredMatches.add(match);
        }
        if (!filteredMatches.isEmpty()) {
            try {
                readLock.lock();
                BiFunction<Configuration.Module, Iterable<URL>, URL[]> matcher = (module, searchPath) -> {
                    URL[] ret = null;
                    if (module.includes(name)) {
                        outer: for (URL searchPathEntry : searchPath) {
                            for (URL filteredMatch : filteredMatches) {
                                if (filteredMatch != null && filteredMatch.getPath().replaceFirst("file:", "")
                                        .startsWith(searchPathEntry.getPath())) {
                                    ret = new URL[] { filteredMatch, searchPathEntry };
                                    break outer;
                                }
                            }
                        }
                    }
                    return ret;
                };
                Configuration.Application app = cfg.getCurrentApplication();
                URL matchedClassResource = null, matchingSearchPath = null;
                if (app != null) {
                    // try an application search path match
                    URL[] tmp = matcher.apply(app, cfg.getApplicationSearchPath(app));
                    if (tmp != null) {
                        matchedClassResource = tmp[0];
                        matchingSearchPath = tmp[1];
                    }
                    else {
                        // try matching against the search path of any library "known to" app
                        for (Configuration.Library lib : cfg.getApplicationLibraries(app)) {
                            tmp = matcher.apply(lib,
                                    cfg.getLibrarySearchPath(lib, Configuration.LoadingMode.DYNAMIC, app));
                            if (tmp != null) {
                                matchedClassResource = tmp[0];
                                matchingSearchPath = tmp[1];
                                break;
                            }
                        }
                    }
                    if (matchedClassResource != null) {
                        // matched - load
                        byte[] classData = readClassData(matchedClassResource);
                        return defineClass(name, classData, 0, classData.length,
                                constructClassDomain(matchingSearchPath));
                    }
                }
            }
            finally {
                readLock.unlock();
            }
        }
        throw new ClassNotFoundException(name);
    }

    private byte[] readClassData(URL classResource) {
        try (InputStream in = new BufferedInputStream(classResource.openStream());
                ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            while (in.available() > 0) {
                out.write(in.read());
            }
            return out.toByteArray();

        }
        catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private ProtectionDomain constructClassDomain(URL codeSourceLocation) {
        CodeSource cs = new CodeSource(codeSourceLocation, (Certificate[]) null);
        return new ProtectionDomain(cs, getPermissions(cs), this, null);
    }

}