import java.security.PrivilegedAction;
import java.security.AccessController;
import org.codehaus.groovy.control.CompilationFailedException;

@groovy.transform.CompileStatic
class CacheClassLoader extends GroovyClassLoader{
    private File cacheDir = new File('/11/tmp/a__cache')

    private CacheClassLoader(){throw new RuntimeException("default constructor not allowed")}

    public CacheClassLoader(ClassLoader parent){
        super(parent)
    }
    public CacheClassLoader(Script parent){
        this(parent.getClass().getClassLoader())
    }

    @Override
    protected Class getClassCacheEntry(String name) {
        Class clazz = super.getClassCacheEntry(name)
        if( clazz ){
            println "getClassCacheEntry $name -> got from memory cache"
            return clazz
        }
        def cacheFile = new File(cacheDir, name.tr('.','/')+'.class')
        if( cacheFile.exists() ){
            println "getClassCacheEntry $name -> cache file exists, try to load it"
            //clazz = getPrivelegedLoader().defineClass(name, cacheFile.bytes)
            clazz = getPrivelegedLoader().defineClass(name, cacheFile.bytes)
            super.setClassCacheEntry(clazz)
        }
        return clazz
    }

    private PrivelegedLoader getPrivelegedLoader(){
        PrivelegedLoader loader = AccessController.doPrivileged(new PrivilegedAction<PrivelegedLoader>() {
            public PrivelegedLoader run() {
                return new PrivelegedLoader();
            }
        });
    }
    public class PrivelegedLoader extends CacheClassLoader {
        private final CacheClassLoader delegate

        public PrivelegedLoader(){ 
            super(CacheClassLoader.this)
            this.delegate = CacheClassLoader.this
        }

        public Class loadClass(String name, boolean lookupScriptFiles, boolean preferClassOverScript, boolean resolve) throws ClassNotFoundException, CompilationFailedException {
            Class c = findLoadedClass(name);
            if (c != null) return c;
            return delegate.loadClass(name, lookupScriptFiles, preferClassOverScript, resolve);
        }
    }
}

def c=null
//just to show intermediate class loaders could load some classes that will be used in CacheClassLoader
def cl_0 = new GroovyClassLoader(this.getClass().getClassLoader())
cl_0.addClasspath('/11/tmp/a__cache/commons-lang3-3.5.jar')
//create cache class loader
def cl = new CacheClassLoader(cl_0)

println "---1---"
c = cl.loadClass('A')
c.newInstance().run()

println "---2---"
c = cl.loadClass('A')
c.newInstance().run()

println "---3---"
cl.removeClassCacheEntry('A')
c = cl.loadClass('A')
c.newInstance().run()

println "---4---"
c = cl.loadClass('B')
c.newInstance().run()

println "---5---"
cl.removeClassCacheEntry('A')
cl.removeClassCacheEntry('B')
c = cl.loadClass('B')
c.newInstance().run()

println "---6---"
c = cl.loadClass('C')
println c.newInstance().rnd()