class CustomClassLoader extends ClassLoader {

    public Class loadTheClass(String name, byte[] bytes) {

        return defineClass(name, bytes, 0, bytes.length);
    }
}