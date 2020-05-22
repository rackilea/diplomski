class Accessor {        
    static {
        String path = "/usr/lib/libfoo.so"
        //System.load(path);
        Runtime.getRuntime().load0(groovy.lang.GroovyClassLoader.class, path)
    }
    ...
}