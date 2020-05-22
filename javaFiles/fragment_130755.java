public class CustomClassLoader extends ClassLoader {

    {
        // Custom class loading goes in this non-static initializer.
        loadClass("java.org.myorganisation.package.MyClass");
    }

    public CustomClassLoader() {
        super(CustomClassLoader.class.getClassLoader());
    }

    public CustomClassLoader(ClassLoader parent) {
        super(parent);
    }
}